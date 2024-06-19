package com.meogo.meogo_backend.domain.community.article.controller;

import com.meogo.meogo_backend.domain.community.article.dto.ArticleCreateRequest;
import com.meogo.meogo_backend.domain.community.article.usecase.ArticleUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community")
public class ArticleController {
  @PostMapping
  public void create(@Valid @RequestPart(name = "request") ArticleCreateRequest request, @RequestPart(name = "files") List<MultipartFile> images){
    articleUseCase.create(request, images);
  }

  private final ArticleUseCase articleUseCase;
}