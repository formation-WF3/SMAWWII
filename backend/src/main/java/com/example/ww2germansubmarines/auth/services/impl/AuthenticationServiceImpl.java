package com.example.ww2germansubmarines.auth.services.impl;

import com.example.ww2germansubmarines.auth.rest.dtos.RequeteConnexion;
import com.example.ww2germansubmarines.auth.rest.dtos.RequeteEnregistrement;
import com.example.ww2germansubmarines.auth.rest.dtos.JwtReponseAuthentification;
import com.example.ww2germansubmarines.auth.services.AuthentificationService;
import com.example.ww2germansubmarines.auth.services.JwtService;
import com.example.ww2germansubmarines.core.domain.models.UtilisateurModel;
import com.example.ww2germansubmarines.core.domain.enums.RoleEnum;
import com.example.ww2germansubmarines.core.domain.repositories.UtilisateurRepository;
import com.example.ww2germansubmarines.core.services.RoleService;
import com.example.ww2germansubmarines.core.adapters.RoleAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final RoleService roleService;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtReponseAuthentification enregistrement(RequeteEnregistrement requete) {
        verifierEligibilite(requete);
        UtilisateurModel nouveauMembre = creerNouveauMembre(requete);
        var jwt = jwtService.genererToken(nouveauMembre);
        return JwtReponseAuthentification.builder().token(jwt).build();
    }

    @Override
    public JwtReponseAuthentification connexion(RequeteConnexion requete) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requete.getNomUtilisateur(), requete.getMotDePasse()));
        UtilisateurModel utilisateurModel = utilisateurRepository.findByNomUtilisateur(requete.getNomUtilisateur())
                .orElseThrow(() -> new IllegalArgumentException("Le nom d'utilisateur ou le mot de passe, est invalide !"));

        var jwt = jwtService.genererToken(utilisateurModel);

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    private UtilisateurModel creerNouveauMembre(RequeteEnregistrement requete) {
        RoleModel roleMembre = roleService.getByNom(RoleEnum.MEMBRE);

        UtilisateurModel utilisateurModel = UtilisateurModel.builder()
                .nomUtilisateur(requete.getNomUtilisateur())
                .motDePasse(passwordEncoder.encode(requete.getMotDePasse()))
                .email(requete.getEmail())
                .emailVerifiee(false)
                .dateEnregistrement(LocalDateTime.now())
                .actif(true)
                .role(roleMembre)
                .build();

        return utilisateurRepository.save(utilisateurModel);
    }

    private void verifierEligibilite(RequeteEnregistrement requete) {
        if (utilisateurRepository.existsByNomUtilisateur(requete.getNomUtilisateur())) {
            throw new RuntimeException("L'utilisateur existe déjà");
        }

        if (utilisateurRepository.existsByEmail(requete.getEmail())) {
            throw new RuntimeException("L'adresse Email existe déjà");
        }

        if (!StringUtils.equals(requete.getMotDePasse(), requete.getConfirmeMotDePasse())) {
            throw new RuntimeException("Les mots de passe ne correspondent pas");
        }
    }
    
}
