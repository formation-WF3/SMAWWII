package com.example.ww2germansubmarines.auth.services.impl;

import com.example.ww2germansubmarines.core.domain.repositories.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    final private UtilisateurRepository utilisateurRepository;

    public UserDetails loadUserByUsername(String nomUtilisateur) throws UsernameNotFoundException {
        return utilisateurRepository.findByNomUtilisateur(nomUtilisateur)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("Aucun utilisateur ne correspond à : %s", nomUtilisateur)));
    }
}
