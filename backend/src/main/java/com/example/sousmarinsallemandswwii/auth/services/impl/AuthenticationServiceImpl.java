package com.example.sousmarinsallemandswwii.auth.services.impl;

import com.example.sousmarinsallemandswwii.auth.rest.dtos.ConnexionRequete;
import com.example.sousmarinsallemandswwii.auth.rest.dtos.InscriptionRequete;
import com.example.sousmarinsallemandswwii.auth.rest.dtos.JwtAuthenticationResponse;
import com.example.sousmarinsallemandswwii.auth.services.AuthenticationService;
import com.example.sousmarinsallemandswwii.auth.services.JwtService;
import com.example.sousmarinsallemandswwii.core.domain.enums.RoleEnum;
import com.example.sousmarinsallemandswwii.core.domain.models.RoleModel;
import com.example.sousmarinsallemandswwii.core.domain.models.UtilisateurModel;
import com.example.sousmarinsallemandswwii.core.domain.repositories.UtilisateurRepository;
import com.example.sousmarinsallemandswwii.core.exceptions.RaisonEnum;
import com.example.sousmarinsallemandswwii.core.exceptions.SmawwiiException;
import com.example.sousmarinsallemandswwii.core.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
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
    public JwtAuthenticationResponse inscription(InscriptionRequete requete) {
        verifierEligibilite(requete);

        UtilisateurModel nouveauMembre = creerNouveauMembre(requete);

//        String jwt = jwtService.generateToken(nouveauMembre);
        String jwt = "Vous êtes bien enregistrés";

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse connexion(ConnexionRequete requete) {
        UtilisateurModel utilisateurModel = verifierUtilisateur(requete.getNomUtilisateur());

        verifierMotDePasse(requete.getMotDePasse(), utilisateurModel.getMotDePasse());

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requete.getNomUtilisateur(), requete.getMotDePasse()));

        String jwt = jwtService.generateToken(utilisateurModel);

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    private UtilisateurModel creerNouveauMembre(InscriptionRequete requete) {
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

    private void verifierEligibilite(InscriptionRequete requete) {
        if (utilisateurRepository.existsByNomUtilisateur(requete.getNomUtilisateur())) {
            throw new SmawwiiException(RaisonEnum.UTILISATEUR_DEJA_EXISTANT, HttpStatus.CONFLICT);
        }

        if (utilisateurRepository.existsByEmail(requete.getEmail())) {
            throw new SmawwiiException(RaisonEnum.EMAIL_DEJA_EXISTANTE, HttpStatus.CONFLICT);
        }

        if (!StringUtils.equals(requete.getMotDePasse(), requete.getConfirmeMotDePasse())) {
            throw new SmawwiiException(RaisonEnum.CORRESPONDANCE_MOTS_DE_PASSE_INCORRECTE, HttpStatus.CONFLICT);
        }
    }

    private UtilisateurModel verifierUtilisateur(String nomUtilisateur) {
        return utilisateurRepository.findByNomUtilisateur(nomUtilisateur)
                .orElseThrow(() -> new SmawwiiException(RaisonEnum.IDENTIFICATION_INCORRECTE, HttpStatus.UNAUTHORIZED));
    }

    private void verifierMotDePasse(String motDePasse, String motDePasseHash) {
        if (!passwordEncoder.matches(motDePasse, motDePasseHash)) {
            throw new SmawwiiException(RaisonEnum.AUTHENTIFICATION_INCORRECTE, HttpStatus.FORBIDDEN);
        }
    }

}
