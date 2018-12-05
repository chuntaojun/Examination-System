package com.tensor.org.api.utils.exception;

import java.text.MessageFormat;

/**
 * @author liaochuntao
 */
public class NoSuchRoleTypeException extends RuntimeException {

    private String message;
    private String method;
    private Class cls;

    public NoSuchRoleTypeException(String message, String method, Class cls) {
        super(message);
        this.message = message;
        this.method = method;
        this.cls = cls;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}[{1}]", cls.getName() + method, message);
    }
}
