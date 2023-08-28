package com.example.ww2germansubmarines.article.services;

import com.example.ww2germansubmarines.article.domain.repositories.ArticleRepository;
import com.example.ww2germansubmarines.article.rest.dtos.ArticleDto;
import com.example.ww2germansubmarines.article.adapters.ArticleAdapter;
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
        return articleRepository.findAll() // renvoit la liste de tous les ArticleModels
                // ... puis les transforme en stream pour accéder aux méthodes de programmation fonctionnelle (map, reduce, filter ...)
                .stream()
                // ..., on map chaque élément en ArticleDto à l'aide de l'ArticleAdapter
                .map(articleAdapter::toDto)
                // ..., puis on retransforme le stream en liste à l'aide de la classe Collectors qui dispose de fonction de transformation du stream vers des collections standards
                .collect(Collectors.toList());
    }

    public ArticleDto getById(long id) {
        return articleRepository.findById(id)
                .map(a -> articleAdapter.toDto(a))
                .orElseThrow(() -> new RuntimeException("Article non trouvé !"));
    }

}
