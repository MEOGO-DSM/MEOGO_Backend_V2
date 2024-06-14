package com.meogo.meogo_backend.domain.auth.service;

import com.meogo.meogo_backend.domain.auth.dto.UserRegisterRequest;
import com.meogo.meogo_backend.domain.auth.usecase.UserRegisterUseCase;
import com.meogo.meogo_backend.domain.user.model.UserEntity;
import com.meogo.meogo_backend.domain.user.repository.UserRepository;
import com.meogo.meogo_backend.global.exception.custom.ExistingUserIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegisterService implements UserRegisterUseCase {
    @Override
    public void register(UserRegisterRequest request) {
        validateUserId(request.userId());
        saveUser(request);
    }

    private void saveUser(UserRegisterRequest request) {
        userRepository.save(createEntity(request));
    }

    private void validateUserId(String userId) {
        if (userRepository.existsByUserId(userId)) {
            throw ExistingUserIdException.EXCEPTION;
        }
    }

    private UserEntity createEntity(UserRegisterRequest request) {
        return UserEntity.createUserEntity(
                request.name(),
                request.userId(),
                passwordEncoder.encode(
                        request.password()
                ),
                request.enrolledSchool()
        );
    }

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
}
