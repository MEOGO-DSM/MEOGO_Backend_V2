package com.meogo.meogo_backend.domain.user.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl extends AbstractUserRepository {

    public UserRepositoryImpl(UserCrudRepository userRepository) {
        super(userRepository);
    }
}
