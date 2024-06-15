package com.meogo.meogo_backend.domain.user.repository;

import com.meogo.meogo_backend.domain.user.model.UserEntity;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class AbstractUserRepository implements UserRepository {
    @Override
    public UserEntity save(UserEntity entity) {
        return userRepository.save(entity);
    }

    @Override
    public boolean existsByUserId(String userId) {
        return userRepository.existsByUserId(userId);
    }

    @Override
    public Optional<UserEntity> findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    private final UserCrudRepository userRepository;
}
