package com.meogo.meogo_backend.domain.user.repository;

import com.meogo.meogo_backend.domain.user.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserCrudRepository extends CrudRepository<UserEntity, Long> {
    boolean existsByUserId(String userId);

}
