package com.example.sousmarinsallemandswwii.article.adapters;

import com.example.sousmarinsallemandswwii.article.domain.models.ArticleModel;
import com.example.sousmarinsallemandswwii.article.rest.dtos.ArticleDto;
import com.example.sousmarinsallemandswwii.article.rest.dtos.CommentaireDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ArticleAdapter {

    private CommentaireAdapter commentaireAdapter;

    public ArticleDto toDto(ArticleModel model) {
        List<CommentaireDto> commentaires = !CollectionUtils.isEmpty(model.getCommentaires()) ?
                model.getCommentaires().stream().map(commentaireModel -> commentaireAdapter.toDto(commentaireModel)).collect(Collectors.toList())
                : null;

        return ArticleDto.builder()
                .id(model.getId())
                .titre(model.getTitre())
                .descriptionCourte(model.getDescriptionCourte())
                .texte(model.getTexte())
                .dateCreation(model.getDateCreation())
                .dateModification(model.getDateModification())
                .actif(model.isActif())
                .imageSrc(model.getImageSrc())
                .commentaires(commentaires)
                .categorieNom(model.getCategorie().getNom())
                .utilisateurNom(model.getUtilisateur().getNomUtilisateur())
                .build();
    }
}
