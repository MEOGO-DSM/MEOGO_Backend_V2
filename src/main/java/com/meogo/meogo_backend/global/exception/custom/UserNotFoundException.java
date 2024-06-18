package com.meogo.meogo_backend.global.exception.custom;

import com.meogo.meogo_backend.global.error.Error;
import com.meogo.meogo_backend.global.exception.CustomException;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(Error.USER_NOT_FOUND);
    }
}
