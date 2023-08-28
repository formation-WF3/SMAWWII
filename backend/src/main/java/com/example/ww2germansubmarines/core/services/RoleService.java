package com.example.ww2germansubmarines.core.services;

import com.example.ww2germansubmarines.core.domain.enums.RoleEnum;
import com.example.ww2germansubmarines.core.domain.repositories.RoleRepository;
import com.example.ww2germansubmarines.core.rest.dtos.RoleDto;
import com.example.ww2germansubmarines.core.adapters.RoleAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RoleService {
    private RoleRepository roleRepository;

    private RoleAdapter roleAdapter;

    public List<RoleDto> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleAdapter::toDto)
                .collect(Collectors.toList());
    }

    public RoleDto getById(long id) {
        return roleRepository.findById(id)
                .map(roleAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Role non trouvé !"));
    }

    public RoleDto getByNom(String nom) {
        return roleRepository.findByNom(RoleEnum.valueOf(nom))
                .map(roleAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Role non trouvé !"));
    }
}
