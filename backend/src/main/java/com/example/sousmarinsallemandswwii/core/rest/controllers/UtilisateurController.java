package com.example.sousmarinsallemandswwii.core.rest.controllers;

import com.example.sousmarinsallemandswwii.core.rest.dtos.UtilisateurDto;
import com.example.sousmarinsallemandswwii.core.services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    private UtilisateurService utilisateurService;

    @GetMapping("/{nom}")
    public UtilisateurDto getByNom(@PathVariable String nom) {
        return utilisateurService.getByNom(nom);
    }
}
