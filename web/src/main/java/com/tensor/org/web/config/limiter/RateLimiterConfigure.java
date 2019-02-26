package com.tensor.org.web.config.limiter;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/**
 * @author liaochuntao
 */
public class RateLimiterConfigure {

    private static long MAX_TOKEN_NUMS = 1000L;
    private static long AVERAGE_RATE = 20L;
    private static long RATE_TO_MS_CONVERSION = 1000;
    protected final ArrayList<LimiterRule> limiterRuleRegister = new ArrayList<>();

    public RateLimiterConfigure() {}

    protected class LimiterRule {
        private Pattern urlPattern;
        private RateLimiter rateLimiter;

        public Pattern getUrlPattern() {
            return urlPattern;
        }

        public RateLimiter getRateLimiter() {
            return rateLimiter;
        }

        public LimiterRule url(String url) {
            this.urlPattern = Pattern.compile(url);
            return this;
        }

        public LimiterRule rateLimiter(RateLimiter rateLimiter) {
            this.rateLimiter = rateLimiter;
            return this;
        }

    }

    protected class RateLimiter {
        /**
         * 桶内最大令牌数量
         */
        private long maxTokenNums;
        /**
         * 当前桶内剩余令牌
         */
        private AtomicLong tokens;
        /**
         * 令牌平均填充速率
         */
        private final long averageRate;
        /**
         * 速率单位转换成毫秒
         */
        private final long rateToMsConversion;
        /**
         * 上一次更新桶令牌数量时间
         */
        private AtomicLong lastRefillTime;
        private final Object monitor = 1;

        public RateLimiter() {
            this.maxTokenNums = MAX_TOKEN_NUMS;
            this.averageRate = AVERAGE_RATE;
            this.rateToMsConversion = RATE_TO_MS_CONVERSION;
            this.tokens = new AtomicLong(MAX_TOKEN_NUMS);
            this.lastRefillTime = new AtomicLong(System.currentTimeMillis());
        }

        public RateLimiter(long maxTokenNums, long averageRate) {
            this.maxTokenNums = maxTokenNums;
            this.averageRate = averageRate;
            this.rateToMsConversion = RATE_TO_MS_CONVERSION;
        }

        public RateLimiter(long maxTokenNums, long averageRate, TimeUnit averageRateUnit) {
            this.maxTokenNums = maxTokenNums;
            this.averageRate = averageRate;
            switch (averageRateUnit) {
                case SECONDS:
                    this.rateToMsConversion = 1000;
                    break;
                case MINUTES:
                    this.rateToMsConversion = 60 * 1000;
                    break;
                default:
                    throw new IllegalArgumentException("TimeUnit of " + averageRateUnit + " is not supported");
            }
        }

        public boolean acquire() {
            refillToken(System.currentTimeMillis());
            return consumer();
        }

        void refillToken(long currentTimeMillis) {
            long refillTime = lastRefillTime.get();
            long newTokens = (currentTimeMillis - refillTime) * averageRate / rateToMsConversion;
            if (newTokens > 0) {
                long newRefillTime = refillTime == 0 ?
                        currentTimeMillis : refillTime + newTokens * rateToMsConversion / averageRate;
                if (lastRefillTime.compareAndSet(refillTime, newRefillTime)) {
                    while (true) {
                        long nowTokens = tokens.get();
                        if (tokens.compareAndSet(newTokens, Math.min(maxTokenNums, nowTokens + newTokens))) {
                            return;
                        }
                    }
                }
            }
        }

        boolean consumer() {
            while (true) {
                if (tokens.get() <= 0) {
                    return false;
                }
                tokens.decrementAndGet();
                return true;
            }
        }
    }

    public RateLimiterConfigure addLimiterRule(String url, RateLimiter rateLimiter) {
        limiterRuleRegister.add(new LimiterRule().url(url).rateLimiter(rateLimiter));
        return this;
    }

    public RateLimiterConfigure finish() {
        return this;
    }

}
