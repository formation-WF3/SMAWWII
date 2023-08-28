package com.example.ww2germansubmarines.auth.rest.dtos;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class SignUpRequest {
    @NotBlank(message = "Un nom d'utilisateur est requis")
    @Size(min = 4, max = 30, message = "Doit faire de 4 à 30 caractères")
    private String username;

    @NotBlank(message = "Un mot de passe est requis")
    @Size(min = 8, max = 20, message = "Doit faire de 8 à 20 caractères")
    private String password;

    @NotBlank(message = "Une adresse email est requise")
    @Size(max = 60, message = "Ne doit pas dépasser 60 caractères")
    @Email
    private String email;
}
