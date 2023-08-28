package com.example.ww2germansubmarines.core.rest.controllers;

import com.example.ww2germansubmarines.core.rest.dtos.RoleDto;
import com.example.ww2germansubmarines.core.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/roles")
public class RoleControler {
    private RoleService roleService;

    @GetMapping
    public List<RoleDto> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable long id) {
        return roleService.getById(id);
    }

    @GetMapping("/{nom}")
    public RoleDto getByNom(@PathVariable String nom) {
        return roleService.getByNom(nom);
    }
}
