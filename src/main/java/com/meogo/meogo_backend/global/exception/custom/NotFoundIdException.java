package com.meogo.meogo_backend.global.exception.custom;

import com.meogo.meogo_backend.global.error.Error;
import com.meogo.meogo_backend.global.exception.CustomException;

public class NotFoundIdException extends CustomException {
  public NotFoundIdException() {
    super(Error.NOT_FOUND_ID);
  }
}