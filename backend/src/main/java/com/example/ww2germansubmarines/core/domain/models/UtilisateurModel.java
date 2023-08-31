package com.example.ww2germansubmarines.core.domain.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "utilisateur")
public class UtilisateurModel implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom_utilisateur", length = 30, unique = true, nullable = false)
    private String nomUtilisateur;

    @Column(name="mot_de_passe", nullable = false)
    private String motDePasse;

    @Column(nullable = false)
    private String email;

    @Column(name = "email_verifiee", unique = true, nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
    private RoleModel role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getNom().name()));
    }

    @Override
    public String getUsername() {
        return nomUtilisateur;
    }

    @Override
    public String getPassword() {
        return motDePasse;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return actif;
    }
}
