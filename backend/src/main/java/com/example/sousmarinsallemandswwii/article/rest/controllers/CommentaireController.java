package com.example.sousmarinsallemandswwii.article.rest.controllers;

import com.example.sousmarinsallemandswwii.article.rest.dtos.CommentaireDto;
import com.example.sousmarinsallemandswwii.article.rest.dtos.CommentaireRequete;
import com.example.sousmarinsallemandswwii.article.services.CommentaireService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/articles/{articleId}/commentaires")
public class CommentaireController {
    private CommentaireService commentaireService;

    @PostMapping
    public CommentaireDto ajouter(@PathVariable Long articleId, @AuthenticationPrincipal UserDetails utilisateurCourant, @RequestBody CommentaireRequete commentaireRequete) {
        return commentaireService.enregistrer(articleId, utilisateurCourant.getUsername(), commentaireRequete);
    }

    @PutMapping
    public CommentaireDto modifier(@PathVariable Long articleId, @AuthenticationPrincipal UserDetails utilisateurCourant, @RequestBody CommentaireRequete commentaireRequete) {
        return commentaireService.enregistrer(articleId, utilisateurCourant.getUsername(), commentaireRequete);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public String supprimer(@PathVariable Long articleId, @PathVariable Long id) {
        return commentaireService.supprimer(id);
    }


}
