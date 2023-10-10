package com.example.sousmarinsallemandswwii.article.adapters;

import com.example.sousmarinsallemandswwii.article.domain.models.CategorieModel;
import com.example.sousmarinsallemandswwii.article.rest.dtos.CategorieDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CategorieAdapter {

    public CategorieDto toDto(CategorieModel model) {
        return CategorieDto.builder()
                .id(model.getId())
                .nom(model.getNom())
                .build();
    }
}
