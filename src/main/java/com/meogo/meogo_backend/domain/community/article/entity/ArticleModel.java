package com.meogo.meogo_backend.domain.community.article.entity;

import java.util.List;

public interface ArticleModel {
  Long getId();
  String getTitle();
  String getContent();
  String getSchoolName();
  List<String> getImages();
  List<String> getTags();

  static ArticleEntity createArticleEntity(String title, String content, String schoolName, List<String> images, List<String> tags) {
    return new ArticleEntity(title, content, schoolName, images, tags);
  }
}
