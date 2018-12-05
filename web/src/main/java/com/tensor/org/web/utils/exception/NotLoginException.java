package com.tensor.org.web.utils.exception;

/**
 * @author liaochuntao
 */
public class NotLoginException extends RuntimeException {

    public NotLoginException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
