package com.citasalud.agendamiento.infrastructure.out.persistence.mapper;

import com.citasalud.agendamiento.domain.model.User;
import com.citasalud.agendamiento.infrastructure.out.persistence.entity.RoleEntity;
import com.citasalud.agendamiento.infrastructure.out.persistence.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setNombre(user.getNombre());
        entity.setHashedPassword(user.getHashedPassword());

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(user.getRoleId());
        entity.setRole(roleEntity);

        return entity;
    }

    public User toDomainModel(UserEntity entity) {
        User model = new User(
            entity.getEmail(),
            entity.getNombre(),
            entity.getHashedPassword(),
            entity.getRole().getRoleId()
        );
        model.setId(entity.getId());
        return model;
    }
}