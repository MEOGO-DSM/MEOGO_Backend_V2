package com.meogo.meogo_backend.global.exception.custom;

import com.meogo.meogo_backend.global.error.Error;
import com.meogo.meogo_backend.global.exception.CustomException;

public class ExistingUserIdException extends CustomException {
    public static final CustomException EXCEPTION = new ExistingUserIdException();

    private ExistingUserIdException() {
        super(Error.EXISTING_USERID);
    }
}
