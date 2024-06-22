package com.meogo.meogo_backend.domain.community.article.controller;

import com.meogo.meogo_backend.domain.community.article.dto.ArticleCreateRequest;
import com.meogo.meogo_backend.domain.community.article.dto.ArticleGetResponse;
import com.meogo.meogo_backend.domain.community.article.usecase.ArticleUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/community")
public class ArticleController {
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void create(@Valid @RequestPart(name = "request") ArticleCreateRequest request, @RequestPart(name = "images") List<MultipartFile> images){
    articleUseCase.create(request, images);
  }

  @GetMapping
  public List<ArticleGetResponse> getAll(){
    return articleUseCase.findAll();
  }

  private final ArticleUseCase articleUseCase;
}
