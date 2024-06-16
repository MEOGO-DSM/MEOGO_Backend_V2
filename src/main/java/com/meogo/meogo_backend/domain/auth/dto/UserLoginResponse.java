package com.meogo.meogo_backend.domain.auth.dto;

import java.time.LocalDateTime;

public record UserLoginResponse(
        String accessToken,
        String refreshToken,
        LocalDateTime issuedAt,
        Long expiresIn,
        LoginUserInfo user,
        String role
) {
    public static UserLoginResponse of(String accessToken, String refreshToken, Long expiresIn, Long id, String userId, String role) {
        return new UserLoginResponse(
                accessToken,
                refreshToken,
                LocalDateTime.now(),
                expiresIn,
                LoginUserInfo.of(id, userId),
                role
        );
    }
}

record LoginUserInfo(
        Long id,
        String userId
) {
    static LoginUserInfo of(Long id, String userId) {
        return new LoginUserInfo(id, userId);
    }
}
