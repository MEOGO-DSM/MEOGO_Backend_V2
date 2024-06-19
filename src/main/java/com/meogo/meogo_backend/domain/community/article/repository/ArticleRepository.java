package com.meogo.meogo_backend.domain.community.article.repository;

import com.meogo.meogo_backend.domain.community.article.entity.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {
}
