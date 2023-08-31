package com.example.ww2germansubmarines.core.adapters;

import com.example.ww2germansubmarines.core.domain.models.RoleModel;
import com.example.ww2germansubmarines.core.domain.enums.RoleEnum;
import com.example.ww2germansubmarines.core.rest.dtos.RoleDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@AllArgsConstructor
@Component
public class RoleAdapter {

    public RoleDto toDto(RoleModel model) {
        return RoleDto.builder()
                .id(model.getId())
                .nom(model.getNom().name())
                .build();
    }

    public RoleModel toModel(RoleDto dto) {
        if (dto == null) {
            return null;
        }

        return RoleModel.builder()
                .id(dto.getId())
                .nom(RoleEnum.valueOf(dto.getNom()))
                .build();
    }
}
