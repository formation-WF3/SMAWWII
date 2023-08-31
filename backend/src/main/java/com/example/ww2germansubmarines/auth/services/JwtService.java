package com.example.ww2germansubmarines.auth.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extraireNomUtilisateur(String token);

    String genererToken(UserDetails userDetails);

    boolean isTokenValide(String token, UserDetails userDetails);
}
