package com.meogo.meogo_backend.domain.user.repository;

import com.meogo.meogo_backend.domain.user.model.UserEntity;

public interface UserRepository {
    boolean existsByUserId(String userId);
    UserEntity save(UserEntity entity);

}
