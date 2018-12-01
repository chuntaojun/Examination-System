package com.tensor.org.dao.handler;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * SpringBoot AOP拦截Dubbo切面异常信息
 * @author liaochuntao
 */
@Slf4j
@Aspect
@Component
public class ServiceExceptionHandle {

    @Pointcut(value = "execution(public com.tensor.org.dao.api.*DaoImpl.(..))")
    private void servicePointcut() {}

    @Pointcut(value = "@annotation(org.springframework.transaction.annotation.Transactional)")
    private void transactionalPointcut() {}

}
