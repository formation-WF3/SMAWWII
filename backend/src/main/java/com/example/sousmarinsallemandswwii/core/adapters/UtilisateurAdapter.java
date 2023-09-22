package com.example.sousmarinsallemandswwii.core.adapters;

import com.example.sousmarinsallemandswwii.core.domain.models.RoleModel;
import com.example.sousmarinsallemandswwii.core.domain.models.UtilisateurModel;
import com.example.sousmarinsallemandswwii.core.rest.dtos.UtilisateurDto;
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

    public UtilisateurModel toModel(UtilisateurDto dto, RoleModel role) {
        if (dto == null) {
            return null;
        }

        return UtilisateurModel.builder()
                .id(dto.getId())
                .nomUtilisateur(dto.getNomUtilisateur())
                .email(dto.getEmail())
                .emailVerifiee(dto.isEmailVerifiee())
                .cleActivation(dto.getCleActivation())
                .dateActivation(dto.getDateActivation())
                .dateEnregistrement(dto.getDateEnregistrement())
                .actif(dto.isActif())
                .role(role)
                .build();
    }

}
