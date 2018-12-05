package com.tensor.org.web.config.filter;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tensor.org.api.dao.log.ApiRequestDao;
import com.tensor.org.api.utils.JsonUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liaochuntao
 */
@Slf4j
@Component(value = "registerUrlContainer")
public class RegisterUrlContainer {

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}")
    private ApiRequestDao apiRequestDao;
    private static ConcurrentHashMap<String, RouterInfo> urlContainer;

    /**
     * 初始化获取路由信息
     *
     * @param routerFunctions
     */
    public void init(List<RouterFunction<?>> routerFunctions) {
        urlContainer = routerFunctions
                .stream()
                .map(Object::toString)
                .map(s -> s.split(" -> "))
                .peek(strings -> strings[0] = strings[0].replace("(", "").replace(")", ""))
                .map(strings -> {
                    String[] url = strings[0].split(" && ");
                    return new RouterInfo(url[1], url[0], strings[1]);
                }).collect(ConcurrentHashMap::new, (m, v) -> m.put(v.getUrl(), v), ConcurrentHashMap::putAll);
    }

    /**
     * 返回不可变的map对象
     * @return
     */
    public Map<String, RouterInfo> getUrlContainer() {
        return Collections.unmodifiableMap(urlContainer);
    }

    public void updateRequestInfo(String pattern, RouterInfo routerInfo, boolean update) {
        urlContainer.put(pattern, routerInfo);
        if (update) {
            apiRequestDao.save(JsonUtils.toJson(routerInfo));
        }
    }

    @Data
    public class RouterInfo {
        private final Object successLock = new Object();
        private final Object failLock = new Object();
        private String url;
        private String method;
        private String handler;
        private Date lastRequestTime;
        private Date lastFailRequestTime;
        private long lastRequestSpend;
        private long requestCount;
        private long maxSpendTime;
        private long totalSpendTime;
        private double averageSpendTime;
        private long successRequestCount;
        private long failRequestCount;
        private String errInfo;
        private transient Map<String, Object> errorMap;

        RouterInfo(String url, String method, String handler) {
            this.url = url;
            this.method = method;
            this.handler = handler;
            this.lastRequestSpend = 0L;
            this.requestCount = 0L;
            this.maxSpendTime = 0L;
            this.totalSpendTime = 0L;
            this.averageSpendTime = 0L;
            this.successRequestCount = 0L;
            this.failRequestCount = 0L;
        }

        public void addSpendTime(long spend) {
            this.totalSpendTime += spend;
        }

        public void setLastRequestSpend(long lastRequestSpend) {
            this.lastRequestSpend = lastRequestSpend;
            this.maxSpendTime = Math.max(this.maxSpendTime, lastRequestSpend);
        }

        public void setSuccessRequestCount() {
            synchronized (successLock) {
                this.successRequestCount += 1;
            }
        }

        public void setFailRequestCount() {
            synchronized (failLock) {
                this.successRequestCount = this.successRequestCount == 0 ? 0 : this.successRequestCount - 1;
                this.failRequestCount += 1;
            }
        }

        public void setErrorMap(Map<String, Object> errorMap) {
            this.errorMap = errorMap;
            this.errInfo = JsonUtils.toJson(errorMap);
        }
    }

}
