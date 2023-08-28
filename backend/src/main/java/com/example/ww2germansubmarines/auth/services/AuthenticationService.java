package com.example.ww2germansubmarines.auth.services;

import com.example.ww2germansubmarines.auth.rest.dtos.SignInRequest;
import com.example.ww2germansubmarines.auth.rest.dtos.SignUpRequest;
import com.example.ww2germansubmarines.auth.rest.dtos.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
}
