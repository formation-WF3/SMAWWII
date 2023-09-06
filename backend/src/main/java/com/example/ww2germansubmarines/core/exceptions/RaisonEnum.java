package com.example.ww2germansubmarines.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum RaisonEnum {

    ARTICLE_NON_TROUVE("Article non trouvé !"),
    UTILISATEUR_DEJA_EXISTANT("L'utilisateur existe déjà"),
    EMAIL_DEJA_EXISTANTE("L'adresse Email existe déjà"),
    CORRESPONDANCE_MOTS_DE_PASSE_INCORRECTE("Les mots de passe ne correspondent pas"),
    IDENTIFICATION_INCORRECTE("Indentification incorrecte !"),
    AUTHENTIFICATION_INCORRECTE("Authentification invalide !");

    private final String message;

}
