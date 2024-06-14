package com.meogo.meogo_backend.domain.auth.controller;

import com.meogo.meogo_backend.domain.auth.dto.UserRegisterRequest;
import com.meogo.meogo_backend.domain.auth.usecase.UserRegisterUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRegisterUseCase userRegisterUseCase;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody UserRegisterRequest request) {
        userRegisterUseCase.register(request);
    }
}
