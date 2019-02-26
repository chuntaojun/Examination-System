package com.tensor.org.web.config.limiter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

/**
 * @author liaochuntao
 */
@Slf4j
@Service(value = "rateLimiterService")
public class RateLimiterService {

    @Autowired private RateLimiterConfigure configure;

    public boolean isRateLimited(ServerHttpRequest request) {
        for (RateLimiterConfigure.LimiterRule rule : configure.limiterRuleRegister) {
            if (rule.getUrlPattern().matcher(request.getPath().toString()).matches()) {
                return true;
            }
        }
        return false;
    }

    public boolean isOverloaded(ServerHttpRequest request) {
        for (RateLimiterConfigure.LimiterRule rule : configure.limiterRuleRegister) {
            if (rule.getUrlPattern().matcher(request.getPath().toString()).matches()) {
                return rule.getRateLimiter().acquire();
            }
        }
        return true;
    }

}
