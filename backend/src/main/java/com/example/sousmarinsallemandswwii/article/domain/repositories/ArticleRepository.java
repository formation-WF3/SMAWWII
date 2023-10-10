package com.example.sousmarinsallemandswwii.article.domain.repositories;

import com.example.sousmarinsallemandswwii.article.domain.models.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleModel, Long> {
}
