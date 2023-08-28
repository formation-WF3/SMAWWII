package com.example.ww2germansubmarines.auth.services.impl;

import com.example.ww2germansubmarines.auth.rest.dtos.SignInRequest;
import com.example.ww2germansubmarines.auth.rest.dtos.SignUpRequest;
import com.example.ww2germansubmarines.auth.rest.dtos.JwtAuthenticationResponse;
import com.example.ww2germansubmarines.auth.services.AuthenticationService;
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
    private final RoleAdapter roleAdapter;
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {
        UtilisateurModel utilisateurModel = UtilisateurModel.builder()
                .nomUtilisateur(request.getUsername())
                .motDePasse(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .emailVerifiee(false)
                .cleActivation(null)
                .dateActivation(null)
                .dateEnregistrement(LocalDateTime.now())
                .actif(true)
                .role(roleAdapter.toModel(roleService.getByNom(RoleEnum.MEMBRE.name())))
                .build();
        utilisateurRepository.save(utilisateurModel);
        var jwt = jwtService.generateToken(utilisateurModel);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SignInRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UtilisateurModel utilisateurModel = utilisateurRepository.findByNomUtilisateur(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Le nom d'utilisateur ou le mot de passe, est invalide !"));

        var jwt = jwtService.generateToken(utilisateurModel);

        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
