package com.meogo.meogo_backend.domain.user.repository;

import com.meogo.meogo_backend.domain.user.model.UserEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractUserRepository implements UserRepository {
    private final UserCrudRepository userRepository;

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }

    @Override
    public boolean existsByUserId(String userId) {
        return userRepository.existsByUserId(userId);
    }
}
