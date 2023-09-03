package com.example.ww2germansubmarines.core.rest.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ErreurReponse {
    private String message;
}
