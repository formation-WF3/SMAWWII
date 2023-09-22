package com.example.sousmarinsallemandswwii.article.rest.dtos;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CommentaireDto {
    private long id;
    private String texte;
    private LocalDateTime dateCreation;
    private LocalDateTime dateModification;
    private String utilisateurNom;
}
