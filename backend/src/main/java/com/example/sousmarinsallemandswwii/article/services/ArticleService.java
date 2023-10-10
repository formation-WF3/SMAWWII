package com.example.sousmarinsallemandswwii.article.services;

import com.example.sousmarinsallemandswwii.article.adapters.ArticleAdapter;
import com.example.sousmarinsallemandswwii.article.domain.models.ArticleModel;
import com.example.sousmarinsallemandswwii.article.domain.repositories.ArticleRepository;
import com.example.sousmarinsallemandswwii.article.rest.dtos.ArticleDto;
import com.example.sousmarinsallemandswwii.core.exceptions.EntiteNonTrouveException;
import com.example.sousmarinsallemandswwii.core.exceptions.RaisonEnum;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    private ArticleAdapter articleAdapter;

    public List<ArticleDto> getAll() {
        return articleRepository.findAll() // Renvoit la liste de tous les ArticleModels
                // Puis les transforme en stream pour accéder aux méthodes de programmation fonctionnelle (map, reduce, filter, ...)
                .stream()
                // On map chaque élément en ArticleDto à l'aide de l'ArticleAdapter
                .map(articleAdapter::toDto)
                // Puis on retransforme le stream en liste à l'aide de la classe Collectors qui dispose de fonction de transformation du stream vers des collections standards
                .collect(Collectors.toList());
    }

    public ArticleDto getById(long id) {
        return articleRepository.findById(id)
                .map(a -> articleAdapter.toDto(a))
                .orElseThrow(() -> new EntiteNonTrouveException(RaisonEnum.ARTICLE_NON_TROUVE));
    }

    public ArticleModel getByIdIfExists(long articleId) {
        return articleRepository.findById(articleId)
                .orElseThrow(() -> new EntiteNonTrouveException(RaisonEnum.ARTICLE_NON_TROUVE));
    }
}
