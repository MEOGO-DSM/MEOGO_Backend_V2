package com.meogo.meogo_backend.domain.auth.service;

import com.meogo.meogo_backend.domain.auth.dto.UserLoginRequest;
import com.meogo.meogo_backend.domain.auth.dto.UserLoginResponse;
import com.meogo.meogo_backend.domain.auth.usecase.UserLoginUseCase;
import com.meogo.meogo_backend.domain.user.model.UserModel;
import com.meogo.meogo_backend.domain.user.repository.UserRepository;
import com.meogo.meogo_backend.global.exception.custom.PasswordNotMatchesException;
import com.meogo.meogo_backend.global.exception.custom.UserNotFoundException;
import com.meogo.meogo_backend.global.security.jwt.JwtProperties;
import com.meogo.meogo_backend.global.security.jwt.Tokenizer;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginService implements UserLoginUseCase {
    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        return createUserLoginResponse(
                validateAndGetUser(request)
        );
    }

    private UserLoginResponse createUserLoginResponse(UserModel user) {
        String userId = user.getUserId();

        return UserLoginResponse.of(
                tokenizer.createAccessToken(userId),
                tokenizer.createRefreshToken(userId),
                jwtProperties.exp(),
                user.getId(),
                userId,
                user.getRole().name()
        );
    }

    private UserModel validateAndGetUser(UserLoginRequest request) {
        UserModel user = userRepository.findByUserId(request.userId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw PasswordNotMatchesException.EXCEPTION;
        }
        return user;
    }

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtProperties jwtProperties;
    private final Tokenizer tokenizer;
}
