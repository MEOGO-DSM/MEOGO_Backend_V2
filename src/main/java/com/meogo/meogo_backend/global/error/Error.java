package com.meogo.meogo_backend.global.error;

import lombok.Getter;

@Getter
public enum Error {
    TEST(200, "test exception");

    private final int status;
    private final String message;

    Error(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
