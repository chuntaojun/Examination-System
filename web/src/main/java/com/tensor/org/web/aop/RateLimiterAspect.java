package com.tensor.org.web.aop;

import com.tensor.org.web.config.limiter.RateLimiterConfigure;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Aspect
public class RateLimiterAspect {

    @Autowired private RateLimiterConfigure configure;

    @Pointcut("@annotation(com.tensor.org.web.aop.RateLimiter)")
    public void urlHandler() {}

}
