package com.example.ww2germansubmarines.auth.rest.controllers;

import com.example.ww2germansubmarines.auth.rest.dtos.JwtAuthenticationResponse;
import com.example.ww2germansubmarines.auth.rest.dtos.EnregistrementRequete;
import com.example.ww2germansubmarines.auth.rest.dtos.ConnexionRequete;
import com.example.ww2germansubmarines.auth.services.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthentificationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/enregistrement")
    public ResponseEntity<JwtAuthenticationResponse> enregistrement(@Valid @RequestBody EnregistrementRequete requete) {
        return ResponseEntity.ok(authenticationService.enregistrement(requete));
    }

    @PostMapping("/connexion")
    public ResponseEntity<JwtAuthenticationResponse> connexion(@Valid @RequestBody ConnexionRequete requete) {
        return ResponseEntity.ok(authenticationService.connexion(requete));
    }

}
