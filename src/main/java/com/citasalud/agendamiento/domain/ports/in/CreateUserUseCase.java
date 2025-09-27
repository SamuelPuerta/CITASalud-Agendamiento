package com.citasalud.agendamiento.domain.ports.in;

import com.citasalud.agendamiento.domain.model.User;

public interface CreateUserUseCase {
    User createUser(String email, String nombre, String plainPassword, String roleName);
}