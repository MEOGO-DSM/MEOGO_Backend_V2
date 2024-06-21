package com.meogo.meogo_backend.domain.community.article.service;

import com.meogo.meogo_backend.domain.community.article.dto.ArticleCreateRequest;
import com.meogo.meogo_backend.domain.community.article.dto.ArticleGetResponse;
import com.meogo.meogo_backend.domain.community.article.entity.ArticleEntity;
import com.meogo.meogo_backend.domain.community.article.entity.ArticleModel;
import com.meogo.meogo_backend.domain.community.article.repository.ArticleRepository;
import com.meogo.meogo_backend.domain.community.article.usecase.ArticleUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService implements ArticleUseCase {

  @Override
  public void create(ArticleCreateRequest request, List<MultipartFile> images) {
    ArticleEntity entity = createEntity(request, images);

    repository.save(entity);
  }

  private ArticleEntity createEntity(ArticleCreateRequest request, List<MultipartFile> images) {
    return ArticleModel.createArticleEntity(
            request.title(),
            request.content(),
            request.schoolName(),
            images.stream().map(MultipartFile::getOriginalFilename).toList(),
            request.tags()
    );
  }

  @Override
  public List<ArticleGetResponse> findAll() {
    List<ArticleEntity> findAll = repository.findAll();

    return findAll.stream().map(ArticleGetResponse::of).toList();
  }


  private final ArticleRepository repository;
}
