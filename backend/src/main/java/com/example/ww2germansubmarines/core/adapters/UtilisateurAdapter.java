package com.example.ww2germansubmarines.core.adapters;

import com.example.ww2germansubmarines.core.domain.models.UtilisateurModel;
import com.example.ww2germansubmarines.core.rest.dtos.UtilisateurDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class UtilisateurAdapter {
    private RoleAdapter roleAdapter;

    public UtilisateurDto toDto(UtilisateurModel model) {
        return UtilisateurDto.builder()
                .id(model.getId())
                .nomUtilisateur(model.getNomUtilisateur())
                .motDePasse(model.getMotDePasse())
                .email(model.getEmail())
                .emailVerifiee(model.isEmailVerifiee())
                .cleActivation(model.getCleActivation())
                .dateActivation(model.getDateActivation())
                .dateEnregistrement(model.getDateEnregistrement())
                .actif(model.isActif())
                .role(roleAdapter.toDto(model.getRole())).build();
    }
}
