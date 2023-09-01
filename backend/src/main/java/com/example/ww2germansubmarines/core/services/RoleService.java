package com.example.ww2germansubmarines.core.services;

import com.example.ww2germansubmarines.core.domain.enums.RoleEnum;
import com.example.ww2germansubmarines.core.domain.models.RoleModel;
import com.example.ww2germansubmarines.core.domain.repositories.RoleRepository;
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
