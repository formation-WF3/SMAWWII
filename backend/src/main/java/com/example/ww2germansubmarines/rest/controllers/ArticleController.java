package com.example.ww2germansubmarines.rest.controllers;

import com.example.ww2germansubmarines.rest.dtos.ArticleDto;
import com.example.ww2germansubmarines.services.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
