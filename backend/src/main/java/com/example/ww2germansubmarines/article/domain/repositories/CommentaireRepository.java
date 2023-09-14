package com.example.ww2germansubmarines.article.domain.repositories;

import com.example.ww2germansubmarines.article.domain.models.CommentaireModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentaireRepository extends JpaRepository<CommentaireModel, Long> {

    @Query(value = "SELECT * FROM commentaire WHERE article_id = :id", nativeQuery = true)
    List<CommentaireModel> findAllByArticleId(@Param("id") long id);

    List<CommentaireModel> findByArticle_Id(long id);

    @Query(value = "SELECT c.*, a.titre FROM commentaire c INNER JOIN article a ON c.article_id = a.id WHERE a.titre LIKE %:titre%; ", nativeQuery = true)
    List<CommentaireModel> findAllByArticleTitre(@Param("titre") String titre);

}
