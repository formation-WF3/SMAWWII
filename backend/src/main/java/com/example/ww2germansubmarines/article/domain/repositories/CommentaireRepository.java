package com.example.ww2germansubmarines.article.domain.repositories;

import com.example.ww2germansubmarines.article.domain.models.CommentaireModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<CommentaireModel, Long> {

}
