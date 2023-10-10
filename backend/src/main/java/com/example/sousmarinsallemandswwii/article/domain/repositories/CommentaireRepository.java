package com.example.sousmarinsallemandswwii.article.domain.repositories;

import com.example.sousmarinsallemandswwii.article.domain.models.CommentaireModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentaireRepository extends JpaRepository<CommentaireModel, Long> {

}
