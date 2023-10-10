package com.example.sousmarinsallemandswwii.auth.rest.controllers;

import com.example.sousmarinsallemandswwii.auth.rest.dtos.ConnexionRequete;
import com.example.sousmarinsallemandswwii.auth.rest.dtos.InscriptionRequete;
import com.example.sousmarinsallemandswwii.auth.rest.dtos.JwtAuthenticationResponse;
import com.example.sousmarinsallemandswwii.auth.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/inscription")
    public ResponseEntity<JwtAuthenticationResponse> inscription(@Valid @RequestBody InscriptionRequete requete) {
        return ResponseEntity.ok(authenticationService.inscription(requete));
    }

    @PostMapping("/connexion")
    public ResponseEntity<JwtAuthenticationResponse> connexion(@Valid @RequestBody ConnexionRequete requete) {
        return ResponseEntity.ok(authenticationService.connexion(requete));
    }
}
