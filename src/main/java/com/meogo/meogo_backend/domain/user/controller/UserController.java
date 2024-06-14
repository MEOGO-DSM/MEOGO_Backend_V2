package com.meogo.meogo_backend.domain.user.controller;

import com.meogo.meogo_backend.domain.user.dto.CheckUserIdResponse;
import com.meogo.meogo_backend.domain.user.usecase.CheckUserIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final CheckUserIdUseCase checkUserIdUseCase;

    @GetMapping("/check-userid")
    public CheckUserIdResponse checkUserId(@RequestParam String id) {
        return CheckUserIdResponse.of(id, checkUserIdUseCase.doesExist(id));
    }
}
