package com.meogo.meogo_backend.domain.user.model;

import com.meogo.meogo_backend.domain.auth.dto.UserRegisterRequest;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 4)
    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String userId;

    private String password;

    private String enrolledSchool;

    protected UserEntity() {}

    private UserEntity(String name, String userId, String password, String enrolledSchool) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.enrolledSchool = enrolledSchool;
    }

    public static UserEntity createUserEntity(String name, String userId, String password, String enrolledSchool) {
        return new UserEntity(name, userId, password, enrolledSchool);
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public void updateEnrolledSchool(String enrolledSchool) {
        this.enrolledSchool = enrolledSchool;
    }
}
