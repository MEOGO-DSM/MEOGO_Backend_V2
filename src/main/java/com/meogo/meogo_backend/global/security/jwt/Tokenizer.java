package com.meogo.meogo_backend.global.security.jwt;

import org.springframework.security.core.Authentication;

public interface Tokenizer {
    String createAccessToken(String userId);
    String createRefreshToken(String userId);
    boolean validate(String token);
    Authentication getAuthentication(String token);

}
