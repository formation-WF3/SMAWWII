package com.example.sousmarinsallemandswwii.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum RaisonEnum {

    UTILISATEUR_DEJA_EXISTANT("L'utilisateur existe déjà"),
    EMAIL_DEJA_EXISTANTE("L'adresse Email existe déjà"),
    IDENTIFICATION_INCORRECTE("Indentification incorrecte !"),
    AUTHENTIFICATION_INCORRECTE("Authentification invalide !"),
    CORRESPONDANCE_MOTS_DE_PASSE_INCORRECTE("Les mots de passe ne correspondent pas"),
    UTILISATEUR_INTROUVABLE("Utilisateur introuvable !"),
    ARTICLE_NON_TROUVE("Article non trouvé !"),
    COMMENTAIRE_NON_TROUVE("Commentaire non trouvé !");

    private final String message;
}
