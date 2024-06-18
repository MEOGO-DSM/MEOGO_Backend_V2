package com.meogo.meogo_backend.domain.user.model;

public interface UserModel {
    void changePassword(String password);
    void updateEnrolledSchool(String enrolledSchool);

    Long getId();
    String getName();
    String getUserId();
    String getPassword();
    String getEnrolledSchool();
    UserRole getRole();

    static UserEntity createUserEntity(String name, String userId, String email, String password, String enrolledSchool, UserRole role) {
        return new UserEntity(name, userId, email, password, enrolledSchool, role);
    }
}
