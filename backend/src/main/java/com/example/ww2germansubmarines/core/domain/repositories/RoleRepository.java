package com.example.ww2germansubmarines.core.domain.repositories;

import com.example.ww2germansubmarines.core.domain.enums.RoleEnum;
import com.example.ww2germansubmarines.core.domain.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    Optional<RoleModel> findByNom(RoleEnum nomEnum);
}
