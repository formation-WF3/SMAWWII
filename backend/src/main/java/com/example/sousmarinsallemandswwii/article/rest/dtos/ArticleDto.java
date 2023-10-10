package com.example.sousmarinsallemandswwii.article.rest.dtos;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ArticleDto {
    private long id;
    private String titre;
    private String descriptionCourte;
    private String texte;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    private boolean actif;
    private String imageSrc;
    private String categorieNom;
    private String utilisateurNom;
    private List<CommentaireDto> commentaires;
}
