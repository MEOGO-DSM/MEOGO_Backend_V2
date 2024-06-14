package com.meogo.meogo_backend.domain.user.usecase;

public interface CheckUserIdUseCase {
    boolean doesExist(String userId);

}
