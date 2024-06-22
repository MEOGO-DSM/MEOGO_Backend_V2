package com.meogo.meogo_backend.domain.community.article.entity;

import com.meogo.meogo_backend.domain.community.article.dto.ArticleRequest;
import com.meogo.meogo_backend.global.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@Getter
public class ArticleEntity implements ArticleModel{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String userName;

  @Column(nullable = false)
  @Length(min = 1, max = 20)
  private String title;

  @Column(nullable = false)
  @Length(min = 1, max = 300)
  private String content;

  private String schoolName;

  @Convert(converter = StringListConverter.class)
  private List<String> images;

  @Convert(converter = StringListConverter.class)
  private List<String> tags;

  protected ArticleEntity(){}

  protected ArticleEntity(String userName, String title, String content, String schoolName, List<String> images, List<String> tags){
    this.userName = userName;
    this.title = title;
    this.content = content;
    this.schoolName = schoolName;
    this.images = images;
    this.tags = tags;
  }

  @Override
  public void update(ArticleRequest articleRequest, List<MultipartFile> images) {
    this.title = articleRequest.title();
    this.content = articleRequest.content();
    this.schoolName = articleRequest.schoolName();
    this.images = images.stream().map(MultipartFile::getOriginalFilename).toList();
    this.tags = articleRequest.tags();
  }
}
