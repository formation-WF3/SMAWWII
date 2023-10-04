package com.example.sousmarinsallemandswwii.core.exceptions;

import org.springframework.http.HttpStatus;

public class EntiteNonTrouveException extends SmawwiiException {

    public EntiteNonTrouveException(RaisonEnum raison) {
        super(raison, HttpStatus.NOT_FOUND);
    }
}
