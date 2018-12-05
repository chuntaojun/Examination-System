package com.tensor.org.web.aop;

import com.tensor.org.api.utils.BusinessType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HasRole {

    BusinessType.RoleType role() default BusinessType.RoleType.ROLE_ADMIN;

}
