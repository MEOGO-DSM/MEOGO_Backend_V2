package com.meogo.meogo_backend.global.current;

import com.meogo.meogo_backend.domain.user.model.UserModel;
import org.springframework.security.core.Authentication;

public interface CurrentUser {
  UserModel getCurrentUser();
}
