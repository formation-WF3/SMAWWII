package com.example.ww2germansubmarines.auth.rest.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$", message = "Le mot de passe doit être composé d'au moins 8 caractères, d'au moins une lettre majuscule, d'au moins une lettre minuscule, et d'au moins un chiffre")
    private String motDePasse;
}
