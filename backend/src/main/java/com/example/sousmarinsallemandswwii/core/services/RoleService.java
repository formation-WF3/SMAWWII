package com.example.sousmarinsallemandswwii.core.services;

import com.example.sousmarinsallemandswwii.core.domain.enums.RoleEnum;
import com.example.sousmarinsallemandswwii.core.domain.models.RoleModel;
import com.example.sousmarinsallemandswwii.core.domain.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class RoleService {
    private RoleRepository roleRepository;

    public RoleModel getByNom(RoleEnum role) {
        return roleRepository.findByNom(role)
                .orElseGet(() -> roleRepository.save(RoleModel.builder().nom(role).build()));
    }
}
