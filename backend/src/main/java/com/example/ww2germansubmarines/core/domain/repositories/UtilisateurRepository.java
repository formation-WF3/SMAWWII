package com.example.ww2germansubmarines.core.domain.repositories;

import com.example.ww2germansubmarines.core.domain.models.UtilisateurModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<UtilisateurModel, Long> {

    Optional<UtilisateurModel> findByNomUtilisateur(String nom);

    Boolean existsByNomUtilisateur(String nomUtilisateur);

    Boolean existsByEmail(String email);
}
