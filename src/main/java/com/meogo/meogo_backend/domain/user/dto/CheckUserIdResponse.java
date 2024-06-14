package com.meogo.meogo_backend.domain.user.dto;

public record CheckUserIdResponse(
        String targetId,
        boolean doesExist
) {

    public static CheckUserIdResponse of(String targetId, boolean doesExist) {
        return new CheckUserIdResponse(targetId, doesExist);
    }
}
