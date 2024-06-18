package com.meogo.meogo_backend.global.exception.custom;

import com.meogo.meogo_backend.global.error.Error;
import com.meogo.meogo_backend.global.exception.CustomException;

public class PasswordNotMatchesException extends CustomException {
    public static final CustomException EXCEPTION = new PasswordNotMatchesException();

    private PasswordNotMatchesException() {
        super(Error.PASSWORD_NOT_MATCHES);
    }
}
