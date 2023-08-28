package com.example.ww2germansubmarines.article.rest.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

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
}
