package com.meogo.meogo_backend.domain.community.article.entity;

import com.meogo.meogo_backend.domain.community.article.dto.ArticleRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ArticleModel {
  Long getId();
  String getTitle();
  String getContent();
  String getSchoolName();
  List<String> getImages();
  List<String> getTags();
  void update(ArticleRequest articleRequest, List<MultipartFile> images);

  static ArticleEntity createArticleEntity(String userName, String title, String content, String schoolName, List<String> images, List<String> tags) {
    return new ArticleEntity(userName, title, content, schoolName, images, tags);
  }
}
