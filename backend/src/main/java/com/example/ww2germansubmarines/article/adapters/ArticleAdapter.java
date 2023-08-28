package com.example.ww2germansubmarines.article.adapters;

import com.example.ww2germansubmarines.article.domain.models.ArticleModel;
import com.example.ww2germansubmarines.article.rest.dtos.ArticleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ArticleAdapter {

    public ArticleDto toDto(ArticleModel model) {
        return ArticleDto.builder()
                .id(model.getId())
                .titre(model.getTitre())
                .descriptionCourte(model.getDescriptionCourte())
                .texte(model.getTexte())
                .dateCreation(model.getDateCreation())
                .dateModification(model.getDateModification())
                .actif(model.isActif())
                .imageSrc(model.getImageSrc())
                .categorieNom(model.getCategorie().getNom())
                .utilisateurNom(model.getUtilisateur().getNomUtilisateur())
                .build();
    }
}
