package com.tensor.org.web.utils.exception;

/**
 * jwt token验证错误异常
 * @author liaochuntao
 */
public class JwtTokenVerifyException extends RuntimeException {

    public JwtTokenVerifyException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
