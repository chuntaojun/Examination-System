package com.tensor.org.web.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Aspect
public class SecurityAspect {

    @Pointcut("execution(* com.tensor.org.web.handler..*.*(..))")
    public void securityHandler() {}

    @Before("securityHandler()")
    public void beforeExecute(JoinPoint joinPoint) {

    }

}
