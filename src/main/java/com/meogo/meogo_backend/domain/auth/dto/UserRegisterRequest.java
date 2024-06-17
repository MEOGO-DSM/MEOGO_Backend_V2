package com.meogo.meogo_backend.domain.auth.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegisterRequest(
        @Size(min = 2, max = 5, message = "이름을 2글자 이상 5글자 이하로 입력해주세요.")
        String name,
        @Size(min = 5, max = 15, message = "아이디를 5글자 이상 15글자 이하로 입력해주세요.")
        String userId,
        @Size(min = 8, max = 20, message = "비밀번호를 8글자 이상 20글자 이하로 입력해주세요.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d!@#$%^&*()-=_+]*$",
                message = "비밀번호에 영문, 특수문자 포함시켜주세요.")
        String password,
        String enrolledSchool
) {
}
