package com.example.ww2germansubmarines.article.adapters;

import com.example.ww2germansubmarines.article.domain.models.ArticleModel;
import com.example.ww2germansubmarines.article.domain.models.CommentaireModel;
import com.example.ww2germansubmarines.article.rest.dtos.CommentaireDto;
import com.example.ww2germansubmarines.core.domain.models.UtilisateurModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CommentaireAdapter {

    public CommentaireDto toDto(CommentaireModel model) {
        return CommentaireDto.builder()
                .id(model.getId())
                .texte(model.getTexte())
                .dateCreation(model.getDateCreation())
                .dateModification(model.getDateModification())
                .utilisateurNom(model.getUtilisateur().getNomUtilisateur())
                .articleTitre(model.getArticle().getTitre())
                .build();
    }

    public CommentaireModel toModel(CommentaireDto dto, UtilisateurModel utilisateurModel, ArticleModel articleModel) {
        if (dto == null) {
            return null;
        }

        return CommentaireModel.builder()
                .id(dto.getId())
                .texte(dto.getTexte())
                .dateCreation(dto.getDateCreation())
                .dateModification(dto.getDateModification())
                .utilisateur(utilisateurModel)
                .article(articleModel)
                .build();
    }
}
