package com.tensor.org.web.utils.exception;

/**
 * @author liaochuntao
 */
public class NotAuthorizationException extends RuntimeException {

    public NotAuthorizationException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
