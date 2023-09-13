package com.example.ww2germansubmarines.article.services;

import com.example.ww2germansubmarines.article.adapters.CommentaireAdapter;
import com.example.ww2germansubmarines.article.domain.models.ArticleModel;
import com.example.ww2germansubmarines.article.domain.models.CommentaireModel;
import com.example.ww2germansubmarines.article.domain.repositories.ArticleRepository;
import com.example.ww2germansubmarines.article.domain.repositories.CommentaireRepository;
import com.example.ww2germansubmarines.article.rest.dtos.CommentaireDto;
import com.example.ww2germansubmarines.core.domain.models.UtilisateurModel;
import com.example.ww2germansubmarines.core.domain.repositories.UtilisateurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CommentaireService {
    private CommentaireRepository commentaireRepository;

    private CommentaireAdapter commentaireAdapter;

    private UtilisateurRepository utilisateurRepository;

    private ArticleRepository articleRepository;

    public List<CommentaireDto> getAll() {
        return commentaireRepository.findAll()
                .stream()
                .map(commentaireAdapter::toDto)
                .collect(Collectors.toList());
    }

    public List<CommentaireDto> getAllByArticleId(long id) {
        return commentaireRepository.findAllByArticleId(id)
                .stream()
                .map(commentaireAdapter::toDto)
                .collect(Collectors.toList());
    }

    public List<CommentaireDto> getAllByArticleTitre(String titre) {
        return commentaireRepository.findAllByArticleTitre(titre)
                .stream()
                .map(commentaireAdapter::toDto)
                .collect(Collectors.toList());
    }

    public CommentaireDto add(CommentaireDto commentaireDto) {
        String utilisateurNom = commentaireDto.getUtilisateurNom();
        String articleTitre = commentaireDto.getArticleTitre();
        UtilisateurModel utilisateurModel = null;
        ArticleModel articleModel = null;

        if (utilisateurNom != null) {
            utilisateurModel = utilisateurRepository.findByNomUtilisateur(utilisateurNom).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
        }

        if (articleTitre != null) {
            articleModel = articleRepository.findByTitreIgnoreCase(articleTitre).orElseThrow(() -> new RuntimeException("Article non trouvé !"));
        }

        CommentaireModel commentaireModel = commentaireAdapter.toModel(commentaireDto, utilisateurModel, articleModel);
        commentaireModel = commentaireRepository.save(commentaireModel);
        commentaireDto.setId(commentaireModel.getId());
        return commentaireDto;
    }

}
