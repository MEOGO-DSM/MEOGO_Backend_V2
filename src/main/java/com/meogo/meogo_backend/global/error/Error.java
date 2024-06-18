package com.meogo.meogo_backend.global.error;

import lombok.Getter;

@Getter
public enum Error {
    ALREADY_EXISTING_USERID(409, "이미 사용 중인 유저 아이디입니다."),
    PASSWORD_NOT_MATCHES(401, "비밀번호가 올바르지 않습니다."),
    USER_NOT_FOUND(404, "해당 유저를 찾지 못했습니다."),
    TEST(200, "test exception");

    private final int status;
    private final String message;

    Error(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
