package com.example.ww2germansubmarines.core.rest.dtos;

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
    private String motDePasse;
    private String email;
    private boolean emailVerifiee;
    private String cleActivation;
    private LocalDateTime dateActivation;
    private LocalDateTime dateEnregistrement;
    private boolean actif;
    private RoleDto role;
}
