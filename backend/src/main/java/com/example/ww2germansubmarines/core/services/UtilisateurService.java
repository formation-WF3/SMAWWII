package com.example.ww2germansubmarines.core.services;

import com.example.ww2germansubmarines.core.adapters.UtilisateurAdapter;
import com.example.ww2germansubmarines.core.domain.repositories.UtilisateurRepository;
import com.example.ww2germansubmarines.core.rest.dtos.UtilisateurDto;
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
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }
}
