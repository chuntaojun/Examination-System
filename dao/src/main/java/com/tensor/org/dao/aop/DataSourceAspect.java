package com.tensor.org.dao.aop;

import com.tensor.org.dao.config.JdbcContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author liaochuntao
 */
@Slf4j
@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    @Pointcut("execution(* com.tensor.org.dao.api..*.*(..))")
    public void aspect() {}

    @Before("aspect()")
    private void switchDataSource(JoinPoint joinPoint) {
        Object target = joinPoint.getTarget();
        String method = joinPoint.getSignature().getName();
        Class<?> cls = target.getClass();
        Class<?>[] paramTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
        try {
            Method m = cls.getMethod(method, paramTypes);
            if (m != null && m.isAnnotationPresent(Dynamic.class)) {
                Dynamic dynamic = m.getAnnotation(Dynamic.class);
                JdbcContextHolder.set(dynamic.value());
                log.info("切换数据源完成 ： {}", dynamic.value());
            }
        } catch (NoSuchMethodException e) {
            log.error("switchDataSource NoSuchMethodException Err : {}", e.getMessage());
        }
    }

}
