package com.tensor.org.web.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liaochuntao
 */
@Slf4j
@Component(value = "registerUrlContainer")
public class RegisterUrlContainer {

    private static ConcurrentHashMap<String, RouterInfo> urlMap;

    /**
     * 初始化获取路由信息
     * @param routerFunctions
     */
    public void init(List<RouterFunction<?>> routerFunctions) {
        urlMap = routerFunctions
                .stream()
                .map(Object::toString)
                .map(s -> s.split(" -> "))
                .map(strings -> {
                    strings[0] = strings[0].replace("(", "").replace(")", "");
                    return strings;
                })
                .map(strings -> {
                    String[] url = strings[0].split(" && ");
                    return new RouterInfo(url[1], url[0], strings[1]);
                }).collect(ConcurrentHashMap::new, (m, v) -> m.put(v.getUrl(), v), ConcurrentHashMap::putAll);
    }

    public class RouterInfo {
        private String url;
        private String method;
        private String handler;
        private long requestCount;
        private long maxSpendTime;
        private long totalSpendTime;
        private long averageSpendTime;

        public RouterInfo(String url, String method, String handler) {
            this.url = url;
            this.method = method;
            this.handler = handler;
            this.requestCount = 0;
            this.maxSpendTime = 0;
            this.totalSpendTime = 0;
            this.averageSpendTime = 0;
        }

        public String getUrl() {
            return url;
        }

        public String getMethod() {
            return method;
        }

        public String getHandler() {
            return handler;
        }

        public long getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(long requestCount) {
            this.requestCount = requestCount;
        }

        public long getMaxSpendTime() {
            return maxSpendTime;
        }

        public void setMaxSpendTime(long maxSpendTime) {
            this.maxSpendTime = maxSpendTime;
        }

        public long getTotalSpendTime() {
            return totalSpendTime;
        }

        public void setTotalSpendTime(long totalSpendTime) {
            this.totalSpendTime = totalSpendTime;
        }

        public long getAverageSpendTime() {
            return averageSpendTime;
        }

        public void setAverageSpendTime(long averageSpendTime) {
            this.averageSpendTime = averageSpendTime;
        }
    }

}
