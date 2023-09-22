package com.example.sousmarinsallemandswwii.core.rest.dtos;

import com.example.sousmarinsallemandswwii.core.domain.enums.RoleEnum;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UtilisateurDto {
    private long id;
    private String nomUtilisateur;
    private String email;
    private boolean emailVerifiee;
    private String cleActivation;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateActivation;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime dateEnregistrement;

    private boolean actif;
    private RoleEnum role;
}
