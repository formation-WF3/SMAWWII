package com.example.ww2germansubmarines.core.exceptions;

import org.springframework.http.HttpStatus;

public class EntiteNonTrouveException extends Ww2gsException {

    public EntiteNonTrouveException(RaisonEnum raison) {
        super(raison, HttpStatus.NOT_FOUND);
    }
}
