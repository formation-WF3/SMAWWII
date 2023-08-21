package com.example.ww2germansubmarines.domain.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "utilisateur")
public class UtilisateurModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom_utilisateur", length = 30, nullable = false)
    private String nomUtilisateur;

    @Column(name="mot_de_passe", nullable = false)
    private String motDePasse;

    @Column(length = 60, nullable = false)
    private String email;

    @Column(name = "email_verifiee", nullable = false)
    private boolean emailVerifiee;

    @Column(name = "cle_activation")
    private String cleActivation;

    @Column(name = "date_activation")
    private LocalDateTime dateActivation;

    @CreatedDate
    @Column(name = "date_enregistrement", nullable = false)
    private LocalDateTime dateEnregistrement;

    @Column(nullable = false)
    private boolean actif;

}
