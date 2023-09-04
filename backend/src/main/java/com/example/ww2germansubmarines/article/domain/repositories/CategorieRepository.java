package com.example.ww2germansubmarines.article.domain.repositories;

import com.example.ww2germansubmarines.article.domain.models.CategorieModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<CategorieModel, Long> {
}
