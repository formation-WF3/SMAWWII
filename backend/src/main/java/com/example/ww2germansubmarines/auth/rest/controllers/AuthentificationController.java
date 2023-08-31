package com.example.ww2germansubmarines.auth.rest.controllers;

import com.example.ww2germansubmarines.auth.rest.dtos.RequeteConnexion;
import com.example.ww2germansubmarines.auth.rest.dtos.RequeteEnregistrement;
import com.example.ww2germansubmarines.auth.rest.dtos.JwtReponseAuthentification;
import com.example.ww2germansubmarines.auth.services.AuthentificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@Valid @RequestBody SignUpRequest request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@Valid @RequestBody SignInRequest request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }

}
