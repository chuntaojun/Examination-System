package com.tensor.org.web.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD})
public @interface RateLimiter {

    TimeUnit type() default TimeUnit.SECONDS;

    int max() default  60;

    int timeWindows() default 60;

}
