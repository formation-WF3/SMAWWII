package com.example.ww2germansubmarines.auth.services;

import com.example.ww2germansubmarines.auth.rest.dtos.RequeteConnexion;
import com.example.ww2germansubmarines.auth.rest.dtos.RequeteEnregistrement;
import com.example.ww2germansubmarines.auth.rest.dtos.JwtReponseAuthentification;


public interface AuthentificationService {

    JwtReponseAuthentification enregistrement(RequeteEnregistrement requete);

    JwtReponseAuthentification connexion(RequeteConnexion requete);

}
