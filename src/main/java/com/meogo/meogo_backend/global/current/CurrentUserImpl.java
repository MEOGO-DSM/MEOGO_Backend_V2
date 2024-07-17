package com.meogo.meogo_backend.global.current;

import com.meogo.meogo_backend.domain.user.model.UserModel;
import com.meogo.meogo_backend.domain.user.repository.UserRepository;
import com.meogo.meogo_backend.global.exception.custom.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CurrentUserImpl implements CurrentUser {
  @Override
  public UserModel getCurrentUser() {
    String userId = SecurityContextHolder.getContext().getAuthentication().getName();

    return userRepository.findByUserId(userId)
            .orElseThrow(() -> UserNotFoundException.EXCEPTION );
  }

  private final UserRepository userRepository;
}
