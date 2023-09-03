package com.example.ww2germansubmarines.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum RaisonEnum {

    ARTICLE_NON_TROUVE("Article non trouvé !"),
    AUTHENTIFICATION_INVALIDE("Le nom d'utilisateur ou le mot de passe, est invalide !");

    private final String message;

}
