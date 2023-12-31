package com.example.sousmarinsallemandswwii.article.rest.controllers;

import com.example.sousmarinsallemandswwii.article.rest.dtos.CategorieDto;
import com.example.sousmarinsallemandswwii.article.services.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/categories")
public class CategorieController {
    private CategorieService categorieService;

    @GetMapping
    public List<CategorieDto> getAll() {
        return categorieService.getAll();
    }
}
