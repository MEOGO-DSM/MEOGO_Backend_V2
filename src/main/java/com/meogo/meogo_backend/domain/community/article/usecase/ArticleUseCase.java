package com.meogo.meogo_backend.domain.community.article.usecase;

import com.meogo.meogo_backend.domain.community.article.dto.ArticleCreateRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleUseCase {
  void create(ArticleCreateRequest request, List<MultipartFile> images);
}
