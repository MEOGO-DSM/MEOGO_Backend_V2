package com.meogo.meogo_backend.domain.auth.usecase;

import com.meogo.meogo_backend.domain.auth.dto.UserLoginRequest;
import com.meogo.meogo_backend.domain.auth.dto.UserLoginResponse;

public interface UserLoginUseCase {
    UserLoginResponse login(UserLoginRequest request);

}
