package com.example.ww2germansubmarines.article.domain.repositories;

import com.example.ww2germansubmarines.article.domain.models.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticleRepository extends JpaRepository<ArticleModel, Long> {

    Optional<ArticleModel> findByTitreIgnoreCase(String titre);
}
