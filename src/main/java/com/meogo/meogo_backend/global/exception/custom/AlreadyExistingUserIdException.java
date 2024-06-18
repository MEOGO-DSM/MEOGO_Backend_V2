package com.meogo.meogo_backend.global.exception.custom;

import com.meogo.meogo_backend.global.error.Error;
import com.meogo.meogo_backend.global.exception.CustomException;

public class AlreadyExistingUserIdException extends CustomException {
    public static final CustomException EXCEPTION = new AlreadyExistingUserIdException();

    private AlreadyExistingUserIdException() {
        super(Error.ALREADY_EXISTING_USERID);
    }
}
