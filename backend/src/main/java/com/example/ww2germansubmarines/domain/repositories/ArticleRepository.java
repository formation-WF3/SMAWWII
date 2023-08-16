package com.example.ww2germansubmarines.domain.repositories;

import com.example.ww2germansubmarines.domain.models.ArticleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<ArticleModel, Long> {
}
