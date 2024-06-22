package com.meogo.meogo_backend.domain.community.article.service;

import com.meogo.meogo_backend.domain.community.article.dto.ArticleRequest;
import com.meogo.meogo_backend.domain.community.article.dto.ArticleGetResponse;
import com.meogo.meogo_backend.domain.community.article.entity.ArticleEntity;
import com.meogo.meogo_backend.domain.community.article.entity.ArticleModel;
import com.meogo.meogo_backend.domain.community.article.repository.ArticleRepository;
import com.meogo.meogo_backend.domain.community.article.usecase.ArticleUseCase;
import com.meogo.meogo_backend.global.exception.custom.NotFoundIdException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleService implements ArticleUseCase {

  @Override
  public void create(ArticleRequest request, List<MultipartFile> images) {
    ArticleEntity entity = createEntity(request, images);

    repository.save(entity);
  }

  @Override
  public void update(Long id, ArticleRequest request, List<MultipartFile> images) {
    ArticleEntity findEntity = repository.findById(id).orElseThrow(NotFoundIdException::new);
    findEntity.update(request, images);
  }

  @Override
  public List<ArticleGetResponse> findAll() {
    List<ArticleEntity> result = repository.findAll();

    return result.stream().map(ArticleGetResponse::of).toList();
  }

  private ArticleEntity createEntity(ArticleRequest request, List<MultipartFile> images) {
    return ArticleModel.createArticleEntity(
            request.title(),
            request.content(),
            request.schoolName(),
            images.stream().map(MultipartFile::getOriginalFilename).toList(),
            request.tags()
    );
  }

  private final ArticleRepository repository;
}
