package com.example.ww2germansubmarines.core.services.adapters;

import com.example.ww2germansubmarines.core.domain.models.UtilisateurModel;
import com.example.ww2germansubmarines.core.rest.dtos.UtilisateurDto;
import org.springframework.stereotype.Component;

@Component
public class UtilisateurAdapter {
    public UtilisateurDto toDto(UtilisateurModel model) {
        return UtilisateurDto.builder()
                .id(model.getId())
                .nomUtilisateur(model.getNomUtilisateur())
                .email(model.getEmail())
                .emailVerifiee(model.isEmailVerifiee())
                .cleActivation(model.getCleActivation())
                .dateActivation(model.getDateActivation())
                .dateEnregistrement(model.getDateEnregistrement())
                .actif(model.isActif())
                .role(model.getRole().getNom())
                .build();
    }
}
