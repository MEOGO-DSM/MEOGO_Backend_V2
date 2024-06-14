package com.meogo.meogo_backend.global.error;

import com.meogo.meogo_backend.global.exception.CustomException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.sql.Timestamp;

public record ErrorResponse(
        int status,
        String message,
        String timestamp,
        String path,
        String exception
) {

    private static ErrorResponse of(int status, String message, String timestamp, String path, String exception) {
        return new ErrorResponse(status, message, timestamp, path, exception);
    }

    public static ResponseEntity<ErrorResponse> of(Error error, HttpServletRequest request, CustomException e) {
        int status = error.getStatus();

        return ResponseEntity.status(status)
                .body(of(status,
                        error.getMessage(),
                        (new Timestamp(System.currentTimeMillis())).toString(),
                        String.format("%s: %s", request.getMethod(), request.getRequestURI()),
                        e.getClass().getSimpleName()
                ));
    }

    public static ResponseEntity<ErrorResponse> of(MethodArgumentNotValidException e, HttpServletRequest request) {
        final FieldError fieldError = e.getBindingResult().getFieldError();

        assert fieldError != null;
        return ResponseEntity.badRequest()
                .body(of(400,
                        fieldError.getDefaultMessage(),
                        (new Timestamp(System.currentTimeMillis())).toString(),
                        String.format("%s: %s", request.getMethod(), request.getRequestURI()),
                        e.getClass().getSimpleName()
                ));
    }
}
