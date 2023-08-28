package com.example.ww2germansubmarines.article.rest.controllers;

import com.example.ww2germansubmarines.article.rest.dtos.ArticleDto;
import com.example.ww2germansubmarines.article.services.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/articles")
public class ArticleController {
    private ArticleService articleService;

    @GetMapping
    public List<ArticleDto> getAll() {
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public ArticleDto getById(@PathVariable long id) {
        return articleService.getById(id);
    }
}
