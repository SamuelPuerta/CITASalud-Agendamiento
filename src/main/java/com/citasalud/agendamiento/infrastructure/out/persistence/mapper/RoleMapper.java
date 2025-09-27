package com.citasalud.agendamiento.infrastructure.out.persistence.mapper;

import com.citasalud.agendamiento.domain.model.Role;
import com.citasalud.agendamiento.infrastructure.out.persistence.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role toDomainModel(RoleEntity entity) {
        Role model = new Role();
        model.setId(entity.getRoleId());
        model.setName(entity.getName());
        return model;
    }
}