package com.example.sousmarinsallemandswwii.core.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SmawwiiException extends RuntimeException {
    private final HttpStatus httpStatus;

    public SmawwiiException(RaisonEnum raison, HttpStatus httpStatus) {
        super(raison.getMessage());
        this.httpStatus = httpStatus;
    }
}
