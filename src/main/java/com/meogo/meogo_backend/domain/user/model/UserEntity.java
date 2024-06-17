package com.meogo.meogo_backend.domain.user.model;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class UserEntity implements UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 4)
    private String name;

    @Column(nullable = false, length = 15, unique = true)
    private String userId;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String enrolledSchool;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    protected UserEntity(String name, String userId, String email, String password, String enrolledSchool, UserRole role) {
        this.name = name;
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.enrolledSchool = enrolledSchool;
        this.role = role;
    }

    protected UserEntity() {
    }

    @Override
    public void changePassword(String password) {
        this.password = password;
    }

    @Override
    public void updateEnrolledSchool(String enrolledSchool) {
        this.enrolledSchool = enrolledSchool;
    }
}
