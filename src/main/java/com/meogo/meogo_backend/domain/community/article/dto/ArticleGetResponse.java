package com.meogo.meogo_backend.domain.community.article.dto;

import com.meogo.meogo_backend.domain.community.article.entity.ArticleEntity;

import java.util.List;

public record ArticleGetResponse(
        Long id,
        String title,
        String content,
        String schoolName,
        List<String> images,
        List<String> tags
) {
  public static ArticleGetResponse of(ArticleEntity articleEntity){
    return new ArticleGetResponse(
            articleEntity.getId(),
            articleEntity.getTitle(),
            articleEntity.getContent(),
            articleEntity.getSchoolName(),
            articleEntity.getImages(),
            articleEntity.getTags()
    );
  }
}
