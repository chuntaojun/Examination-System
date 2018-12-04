package com.tensor.org.web.aop;

import com.tensor.org.web.config.filter.RegisterUrlContainer;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.util.pattern.PathPattern;
import org.springframework.web.util.pattern.PathPatternParser;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Aspect
public class HttpFilterAspect {



    @Autowired private RegisterUrlContainer registerUrlContainer;

    private Predicate<PathPattern.PathMatchInfo> matchInfoPredicate = Objects::nonNull;
    private Map<String, RegisterUrlContainer.RouterInfo> routerInfoMap;

    @Pointcut("execution(* com.tensor.org.web.handler..*.*(..))")
    public void urlHandler() {}

    public void init(Map<String, RegisterUrlContainer.RouterInfo> routerInfoMap) {
        this.routerInfoMap = routerInfoMap;
    }

    /**
     *
     * @param joinPoint
     */
    @Before("urlHandler()")
    private void beforeHandler(JoinPoint joinPoint) {
        log.info("######### 进入Handler前 #########");
        Object[] args = joinPoint.getArgs();
        ServerRequest request = (ServerRequest) args[0];
        routerInfoMap.values()
                .parallelStream()
                .peek(routerInfo -> {
                    if (matchInfoPredicate.test(pathMatchInfo(routerInfo.getUrl(), request))) {
                        routerInfo.setLastRequestTime(new Date());
                        routerInfo.setRequestCount(routerInfo.getRequestCount() + 1);
                        registerUrlContainer.updateRequestInfo(routerInfo.getUrl(), routerInfo);
                    }
                }).count();
    }

    /**
     *
     * @param joinPoint
     */
    @After("urlHandler()")
    public void afterHandler(JoinPoint joinPoint) {
        log.info("######### 离开Handler前 #########");
        Object[] args = joinPoint.getArgs();
        ServerRequest request = (ServerRequest) args[0];
        routerInfoMap.values()
                .parallelStream()
                .peek(routerInfo -> {
                    if (matchInfoPredicate.test(pathMatchInfo(routerInfo.getUrl(), request))) {
                        routerInfo.setLastRequestSpend(System.currentTimeMillis() - routerInfo.getLastRequestTime().getTime());
                        routerInfo.addSpendTime(routerInfo.getLastRequestSpend());
                        routerInfo.setAverageSpendTime(routerInfo.getTotalSpendTime() * 1.0 / routerInfo.getRequestCount());
                        routerInfo.setSuccessRequestCount();
                        registerUrlContainer.updateRequestInfo(routerInfo.getUrl(), routerInfo);
                    }
                }).count();
    }

    public void afterThrow(ServerRequest request, Map<String, Object> errorMap) {
        log.error("######### 离开Handler前，发生异常 #########");
        routerInfoMap.values()
                .parallelStream()
                .peek(routerInfo -> {
                    if (matchInfoPredicate.test(pathMatchInfo(routerInfo.getUrl(), request))) {
                        routerInfo.setFailRequestCount();
                        routerInfo.setErrorMap(errorMap);
                        registerUrlContainer.updateRequestInfo(routerInfo.getUrl(), routerInfo);
                    }
                }).count();
    }

    private PathPattern.PathMatchInfo pathMatchInfo(String pattern, ServerRequest request) {
        return new PathPatternParser().parse(pattern).matchAndExtract(request.pathContainer());
    }

}
