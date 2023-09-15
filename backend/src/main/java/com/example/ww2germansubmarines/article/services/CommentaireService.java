package com.example.ww2germansubmarines.article.services;

import com.example.ww2germansubmarines.article.adapters.CommentaireAdapter;
import com.example.ww2germansubmarines.article.domain.models.ArticleModel;
import com.example.ww2germansubmarines.article.domain.models.CommentaireModel;
import com.example.ww2germansubmarines.article.domain.repositories.CommentaireRepository;
import com.example.ww2germansubmarines.article.rest.dtos.CommentaireDto;
import com.example.ww2germansubmarines.article.rest.dtos.CommentaireRequete;
import com.example.ww2germansubmarines.core.domain.models.UtilisateurModel;
import com.example.ww2germansubmarines.core.exceptions.EntiteNonTrouveException;
import com.example.ww2germansubmarines.core.exceptions.RaisonEnum;
import com.example.ww2germansubmarines.core.services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class CommentaireService {
    private final CommentaireRepository commentaireRepository;

    private final CommentaireAdapter commentaireAdapter;

    private final UtilisateurService utilisateurService;

    private final ArticleService articleService;

    public CommentaireDto enregistrer(Long articleId, String nomUtilisateur, CommentaireRequete commentaireRequete) {
        UtilisateurModel utilisateurModel = utilisateurService.getByNomIfExists(nomUtilisateur);

        ArticleModel articleModel = articleService.getByIdIfExists(articleId);

        CommentaireModel commentaireModel;
        Long commentaireId = commentaireRequete.getId();

        if (commentaireId != null) {
            commentaireModel = getByIdIfExists(commentaireId);

            commentaireModel.setTexte(commentaireRequete.getTexte());
            commentaireModel.setDateModification(LocalDateTime.now());
        } else {
            commentaireModel = CommentaireModel.builder()
                    .texte(commentaireRequete.getTexte())
                    .dateCreation(LocalDateTime.now())
                    .utilisateur(utilisateurModel)
                    .article(articleModel)
                    .build();
        }

        return commentaireAdapter.toDto(commentaireRepository.save(commentaireModel));
    }

    public CommentaireModel getByIdIfExists(long id) {
        return commentaireRepository.findById(id)
                .orElseThrow(() -> new EntiteNonTrouveException(RaisonEnum.COMMENTAIRE_NON_TROUVE));
    }

}
