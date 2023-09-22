package com.example.sousmarinsallemandswwii.core.services;

import com.example.sousmarinsallemandswwii.core.adapters.UtilisateurAdapter;
import com.example.sousmarinsallemandswwii.core.domain.models.UtilisateurModel;
import com.example.sousmarinsallemandswwii.core.domain.repositories.UtilisateurRepository;
import com.example.sousmarinsallemandswwii.core.exceptions.EntiteNonTrouveException;
import com.example.sousmarinsallemandswwii.core.exceptions.RaisonEnum;
import com.example.sousmarinsallemandswwii.core.rest.dtos.UtilisateurDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    private UtilisateurAdapter utilisateurAdapter;

    public UtilisateurDto getByNom(String nom) {
        return utilisateurRepository.findByNomUtilisateur(nom)
                .map(u -> utilisateurAdapter.toDto(u))
                .orElseThrow(() -> new EntiteNonTrouveException(RaisonEnum.UTILISATEUR_INTROUVABLE));
    }

    public UtilisateurModel getByNomIfExists(String nom) {
        return utilisateurRepository.findByNomUtilisateur(nom)
                .orElseThrow(() -> new EntiteNonTrouveException(RaisonEnum.UTILISATEUR_INTROUVABLE));
    }
}
