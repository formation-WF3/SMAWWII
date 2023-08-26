package com.example.ww2germansubmarines.auth.services;

import com.example.ww2germansubmarines.auth.rest.dtos.JwtAuthenticationResponse;
import com.example.ww2germansubmarines.auth.rest.dtos.ConnexionRequete;
import com.example.ww2germansubmarines.auth.rest.dtos.EnregistrementRequete;


public interface AuthenticationService {

    JwtAuthenticationResponse enregistrement(EnregistrementRequete requete);

    JwtAuthenticationResponse connexion(ConnexionRequete requete);

}
