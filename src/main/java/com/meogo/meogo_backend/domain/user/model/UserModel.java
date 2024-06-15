package com.meogo.meogo_backend.domain.user.model;

public interface UserModel {
    void changePassword(String password);
    void updateEnrolledSchool(String enrolledSchool);

    String getName();
    String getUserId();
    String getPassword();
    String getEnrolledSchool();
    UserRole getRole();

    static UserEntity createUserEntity(String name, String userId, String password, String enrolledSchool, UserRole role) {
        return new UserEntity(name, userId, password, enrolledSchool, role);
    }
}
