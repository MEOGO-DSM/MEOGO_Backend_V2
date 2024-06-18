package com.meogo.meogo_backend.global.error;

import lombok.Getter;

@Getter
public enum Error {
    ALREADY_EXISTING_USERID(409, "이미 사용 중인 유저 아이디입니다."),
    TEST(200, "test exception");

    private final int status;
    private final String message;

    Error(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
