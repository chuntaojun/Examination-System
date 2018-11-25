package com.tensor.org.dao.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * sql执行耗时切面操作，耗时操作包括(http数据传输耗时以及sql执行耗时)
 * @author liaochuntao
 */
@Slf4j
@Component
@Aspect
public class SQLAspect {

    private long spendTime;

    @Pointcut("execution(* com.tensor.org.dao.mapper.*.*Mapper.*(..))")
    public void sql() {}

    @Before("sql()")
    public void beforeSql() {
        spendTime = System.currentTimeMillis();
        log.info("sql 开始执行 ：{}", new Date());
    }

    @After("sql()")
    public void afterSql() {
        log.info("sql 结束执行 ：{}, 共耗时 ：{} milliseconds", new Date(), System.currentTimeMillis() - spendTime);
    }

}
