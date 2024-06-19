package com.meogo.meogo_backend.domain.community.article.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Getter
public class ArticleEntity implements ArticleModel{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @Length(min = 1, max = 20)
  private String title;

  @Column(nullable = false)
  @Length(min = 1, max = 300)
  private String content;

  private String schoolName;

  private List<String> images;

  private List<String> tags;

  protected ArticleEntity(){}

  protected ArticleEntity(String title, String content, String schoolName, List<String> images, List<String> tags){
    this.title = title;
    this.content = content;
    this.schoolName = schoolName;
    this.images = images;
    this.tags = tags;
  }
}
