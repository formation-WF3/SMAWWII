package com.example.ww2germansubmarines.auth.rest.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ConnexionRequete {
    @NotBlank(message = "Le nom d'utilisateur est requis")
    @Size(min = 4, max = 30, message = "Doit être de 4 à 30 caractères")
    private String nomUtilisateur;

    @NotBlank(message = "Le mot de passe est requis")
    @Size(min = 8, max = 20, message = "Doit être de 8 à 20 caractères")
    private String motDePasse;
}
