package com.meogo.meogo_backend.domain.user.service;

import com.meogo.meogo_backend.domain.user.repository.UserRepository;
import com.meogo.meogo_backend.domain.user.usecase.CheckUserIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckUserIdService implements CheckUserIdUseCase {
    @Override
    public boolean doesExist(String userId) {
        return userRepository.existsByUserId(userId);
    }

    private final UserRepository userRepository;
}
