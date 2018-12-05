package com.tensor.org.work.utils.exception;

/**
 * @author liaochuntao
 */
public class NoSuchNoticeGroupNameException extends RuntimeException {

    public NoSuchNoticeGroupNameException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
