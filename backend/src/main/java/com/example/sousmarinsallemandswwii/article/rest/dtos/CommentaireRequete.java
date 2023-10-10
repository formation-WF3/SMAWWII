package com.example.sousmarinsallemandswwii.article.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CommentaireRequete {
    private Long id;
    private String texte;
}
