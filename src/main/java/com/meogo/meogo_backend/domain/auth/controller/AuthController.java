package com.meogo.meogo_backend.domain.auth.controller;

import com.meogo.meogo_backend.domain.auth.dto.UserLoginRequest;
import com.meogo.meogo_backend.domain.auth.dto.UserLoginResponse;
import com.meogo.meogo_backend.domain.auth.dto.UserRegisterRequest;
import com.meogo.meogo_backend.domain.auth.usecase.UserLoginUseCase;
import com.meogo.meogo_backend.domain.auth.usecase.UserRegisterUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserRegisterRequest request) {
        userRegisterUseCase.register(request);
    }

    @PostMapping("/login")
    public UserLoginResponse login(@Valid @RequestBody UserLoginRequest request) {
        return userLoginUseCase.login(request);
    }

    private final UserRegisterUseCase userRegisterUseCase;
    private final UserLoginUseCase userLoginUseCase;
}
