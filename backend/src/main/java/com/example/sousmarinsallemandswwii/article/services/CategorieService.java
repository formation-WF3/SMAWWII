package com.example.sousmarinsallemandswwii.article.services;

import com.example.sousmarinsallemandswwii.article.rest.dtos.CategorieDto;
import com.example.sousmarinsallemandswwii.article.domain.repositories.CategorieRepository;
import com.example.sousmarinsallemandswwii.article.adapters.CategorieAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategorieService {
    private CategorieRepository categorieRepository;

    private CategorieAdapter categorieAdapter;

    public List<CategorieDto> getAll() {
        return categorieRepository.findAll()
                .stream()
                .map(categorieAdapter::toDto)
                .collect(Collectors.toList());
    }
}
