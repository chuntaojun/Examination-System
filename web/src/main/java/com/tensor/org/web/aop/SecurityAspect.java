package com.tensor.org.web.aop;

import com.tensor.org.api.dao.enpity.user.JwtUser;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.web.utils.JwtTokenUtils;
import com.tensor.org.web.utils.StringsValue;
import com.tensor.org.web.utils.exception.NotAuthorizationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Aspect
public class SecurityAspect {

    @Autowired private JwtTokenUtils jwtTokenUtils;

    @Pointcut("execution(* com.tensor.org.web.handler..*.*(..))")
    public void securityHandler() {}

//    @Before("securityHandler()")
    public void beforeExecute(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        ServerRequest request = (ServerRequest) joinPoint.getArgs()[0];
        try {
            Method method = joinPoint.getTarget().getClass().getMethod(methodName);
            if (method.isAnnotationPresent(HasRole.class)) {
                HasRole hasRole = method.getAnnotation(HasRole.class);
                Optional<String> security = JwtTokenUtils.getTokenFromHeader(request);
                security.ifPresent(token -> jwtTokenUtils.tokenVerify(token).ifPresent(decodedJWT -> {
                    JwtUser jwtUser = (JwtUser) JsonUtils.toObj(decodedJWT.getSubject(), JwtUser.class);
                    if (!hasRole.role().getRole().equalsIgnoreCase(jwtUser.getRole())) {
                        throw new NotAuthorizationException(StringsValue.CN.NOT_AUTHORIZATION);
                    }
                }));
            }
        } catch (NoSuchMethodException e) {
            log.error("SecurityAspect NoSuchMethodException Err : {}", e.getMessage());
        }
    }

}
