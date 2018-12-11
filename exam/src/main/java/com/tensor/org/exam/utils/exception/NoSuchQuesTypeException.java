package com.tensor.org.exam.utils.exception;

/**
 * 没有该试题类型异常
 * @author liaochuntao
 */
public class NoSuchQuesTypeException extends RuntimeException {

    public NoSuchQuesTypeException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
