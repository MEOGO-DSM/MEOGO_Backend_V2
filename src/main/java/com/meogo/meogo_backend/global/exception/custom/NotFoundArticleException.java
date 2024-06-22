package com.meogo.meogo_backend.global.exception.custom;

import com.meogo.meogo_backend.global.error.Error;
import com.meogo.meogo_backend.global.exception.CustomException;

public class NotFoundArticleException extends CustomException {
  public NotFoundArticleException() {
    super(Error.NOT_FOUND_ARTICLE);
  }
}