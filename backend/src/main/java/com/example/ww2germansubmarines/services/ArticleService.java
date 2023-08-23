package com.example.ww2germansubmarines.services;

import com.example.ww2germansubmarines.domain.repositories.ArticleRepository;
import com.example.ww2germansubmarines.rest.dtos.ArticleDto;
import com.example.ww2germansubmarines.services.adapters.ArticleAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ArticleService {
    private ArticleRepository articleRepository;

    private ArticleAdapter articleAdapter;

    public List<ArticleDto> getAll() {
        List<ArticleDto> articleDtos = new ArrayList<>();
        articleRepository.findAll().forEach(
                model -> articleDtos.add(articleAdapter.toDto(model))
        );
        return articleDtos;
    }

    public ArticleDto getById(long id) {
        return articleRepository.findById(id)
                .map(a -> articleAdapter.toDto(a))
                .orElseThrow(() -> new RuntimeException("Article non trouvé !"));
    }

}
