package com.meogo.meogo_backend.global.exception;

import com.meogo.meogo_backend.global.error.Error;

public class CustomException extends RuntimeException {
    private final Error error;

    public Error getError() {
        return error;
    }

    public CustomException(Error error) {
        this.error = error;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}