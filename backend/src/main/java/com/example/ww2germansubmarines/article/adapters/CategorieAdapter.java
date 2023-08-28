package com.example.ww2germansubmarines.article.adapters;

import com.example.ww2germansubmarines.article.rest.dtos.CategorieDto;
import com.example.ww2germansubmarines.article.domain.models.CategorieModel;
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
