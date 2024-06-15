package com.meogo.meogo_backend.domain.user.repository;

import com.meogo.meogo_backend.domain.user.model.UserEntity;
import com.meogo.meogo_backend.domain.user.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    boolean existsByUserId(String userId);
    UserEntity save(UserEntity entity);
    Optional<UserEntity> findByUserId(String userId);

}
