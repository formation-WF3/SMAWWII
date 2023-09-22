package com.example.sousmarinsallemandswwii.core.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Ww2gsException extends RuntimeException {
    private final HttpStatus httpStatus;

    public Ww2gsException(RaisonEnum raison, HttpStatus httpStatus) {
        super(raison.getMessage());
        this.httpStatus = httpStatus;
    }

}
