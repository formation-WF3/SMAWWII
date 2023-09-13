package com.example.ww2germansubmarines.article.rest.controllers;

import com.example.ww2germansubmarines.article.rest.dtos.CommentaireDto;
import com.example.ww2germansubmarines.article.services.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/articles/{id}/commentaires")
public class CommentaireController {
    private CommentaireService commentaireService;

    @GetMapping
    public List<CommentaireDto> getAllByArticleId(@PathVariable long id) {
        return commentaireService.getAllByArticleId(id);
    }

    @PostMapping
    public CommentaireDto add(@RequestBody CommentaireDto commentaireDto) {
        return commentaireService.add(commentaireDto);
    }

}
