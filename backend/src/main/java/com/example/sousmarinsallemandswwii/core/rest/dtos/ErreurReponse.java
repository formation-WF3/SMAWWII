package com.example.sousmarinsallemandswwii.core.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ErreurReponse {
    private String message;
}
