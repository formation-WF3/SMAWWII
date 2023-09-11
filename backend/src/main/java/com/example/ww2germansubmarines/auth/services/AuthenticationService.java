package com.example.ww2germansubmarines.auth.services;

import com.example.ww2germansubmarines.auth.rest.dtos.ConnexionRequete;
import com.example.ww2germansubmarines.auth.rest.dtos.InscriptionRequete;
import com.example.ww2germansubmarines.auth.rest.dtos.JwtAuthenticationResponse;


public interface AuthenticationService {

    JwtAuthenticationResponse inscription(InscriptionRequete requete);

    JwtAuthenticationResponse connexion(ConnexionRequete requete);
}
