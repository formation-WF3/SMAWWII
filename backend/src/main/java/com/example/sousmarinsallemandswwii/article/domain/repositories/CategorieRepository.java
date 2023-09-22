package com.example.sousmarinsallemandswwii.article.domain.repositories;

import com.example.sousmarinsallemandswwii.article.domain.models.CategorieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<CategorieModel, Long> {
}
