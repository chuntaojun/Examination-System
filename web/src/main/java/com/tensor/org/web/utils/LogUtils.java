package com.tensor.org.web.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

/**
 * @author liaochuntao
 */
@Slf4j
public class LogUtils<T, R> implements Function {

    @SuppressWarnings("unchecked")
    @Override
    public R apply(Object o) {
        log.info("{}", o);
        return (R) o;
    }

}
