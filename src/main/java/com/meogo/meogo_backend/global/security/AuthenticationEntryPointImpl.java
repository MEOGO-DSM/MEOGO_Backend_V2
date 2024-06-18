package com.meogo.meogo_backend.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meogo.meogo_backend.global.error.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        final int status = HttpStatus.UNAUTHORIZED.value();
        ErrorResponse errorBody = ErrorResponse.of(
                status,
                MESSAGE,
                LocalDateTime.now().toString(),
                String.format("%s: %s", request.getMethod(), request.getRequestURL()),
                AuthenticationEntryPoint.class.getSimpleName()
        );

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(status);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(errorBody));
    }

    private static final String MESSAGE = "해당 경로로 접근할 수 없습니다.";
    private final ObjectMapper objectMapper;
}
