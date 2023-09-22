package com.example.sousmarinsallemandswwii.article.domain.repositories;

import com.example.sousmarinsallemandswwii.article.domain.models.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<ArticleModel, Long> {

    Optional<ArticleModel> findById(long titre);
    Optional<ArticleModel> findByTitreIgnoreCase(String titre);
}
