package com.meogo.meogo_backend.domain.auth.usecase;

import com.meogo.meogo_backend.domain.auth.dto.UserRegisterRequest;

public interface UserRegisterUseCase {
    void register(UserRegisterRequest request);

}
