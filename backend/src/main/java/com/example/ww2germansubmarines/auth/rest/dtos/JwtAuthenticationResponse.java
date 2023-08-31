package com.example.ww2germansubmarines.auth.rest.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class JwtAuthenticationResponse {
    private String token;
}
