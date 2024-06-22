package com.meogo.meogo_backend.domain.community.article.usecase;

import com.meogo.meogo_backend.domain.community.article.dto.ArticleRequest;
import com.meogo.meogo_backend.domain.community.article.dto.ArticleGetResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleUseCase {
  void create(ArticleRequest request, List<MultipartFile> images);

  void update(Long id, ArticleRequest request, List<MultipartFile> images);

  void delete(Long id);

  List<ArticleGetResponse> findAll();
}
