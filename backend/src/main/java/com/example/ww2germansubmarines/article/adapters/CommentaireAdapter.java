package com.example.ww2germansubmarines.article.adapters;

import com.example.ww2germansubmarines.article.domain.models.CommentaireModel;
import com.example.ww2germansubmarines.article.rest.dtos.CommentaireDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CommentaireAdapter {

    public CommentaireDto toDto(CommentaireModel model) {
        if (model == null) {
            return null;
        }

        return CommentaireDto.builder()
                .id(model.getId())
                .texte(model.getTexte())
                .dateCreation(model.getDateCreation())
                .dateModification(model.getDateModification())
                .utilisateurNom(model.getUtilisateur() != null ? model.getUtilisateur().getNomUtilisateur() : null)
                .build();
    }

}
