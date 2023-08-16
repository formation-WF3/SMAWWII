package com.example.ww2germansubmarines.services;

import com.example.ww2germansubmarines.rest.dtos.CategorieDto;
import com.example.ww2germansubmarines.domain.repositories.CategorieRepository;
import com.example.ww2germansubmarines.services.adapters.CategorieAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategorieService {
    private CategorieRepository categorieRepository;

    private CategorieAdapter categorieAdapter;

    public List<CategorieDto> getAll() {
        List<CategorieDto> categorieDtos = new ArrayList<>();
        categorieRepository.findAll().forEach(
                model -> categorieDtos.add(categorieAdapter.toDto(model))
        );
        return categorieDtos;
    }
}
