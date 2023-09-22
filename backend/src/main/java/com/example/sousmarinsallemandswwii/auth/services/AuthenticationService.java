package com.example.sousmarinsallemandswwii.auth.services;

import com.example.sousmarinsallemandswwii.auth.rest.dtos.ConnexionRequete;
import com.example.sousmarinsallemandswwii.auth.rest.dtos.InscriptionRequete;
import com.example.sousmarinsallemandswwii.auth.rest.dtos.JwtAuthenticationResponse;


public interface AuthenticationService {

    JwtAuthenticationResponse inscription(InscriptionRequete requete);

    JwtAuthenticationResponse connexion(ConnexionRequete requete);
}
