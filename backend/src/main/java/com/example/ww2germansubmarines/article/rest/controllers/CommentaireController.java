package com.example.ww2germansubmarines.article.rest.controllers;

import com.example.ww2germansubmarines.article.rest.dtos.CommentaireDto;
import com.example.ww2germansubmarines.article.services.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/commentaires")
public class CommentaireController {
    private CommentaireService commentaireService;

    @GetMapping
    public List<CommentaireDto> getAll() {
        return commentaireService.getAll();
    }

    @GetMapping("/id/{id}")
    public List<CommentaireDto> getAllByArticleId(@PathVariable long id) {
        return commentaireService.getAllByArticleId(id);
    }

    @GetMapping("/{titre}")
    public List<CommentaireDto> getAllByArticleTitre(@PathVariable String titre) {
        return commentaireService.getAllByArticleTitre(titre);
    }

    @PostMapping
    public CommentaireDto add(@RequestBody CommentaireDto commentaireDto) {
        return commentaireService.add(commentaireDto);
    }

}
