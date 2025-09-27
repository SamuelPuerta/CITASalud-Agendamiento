package com.citasalud.agendamiento.application.service;

import com.citasalud.agendamiento.domain.exception.UserAlreadyExistsException;
import com.citasalud.agendamiento.domain.model.Role;
import com.citasalud.agendamiento.domain.model.User;
import com.citasalud.agendamiento.domain.ports.in.CreateUserUseCase;
import com.citasalud.agendamiento.domain.ports.out.RoleRepositoryPort;
import com.citasalud.agendamiento.domain.ports.out.UserRepositoryPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements CreateUserUseCase {

    private final UserRepositoryPort userRepositoryPort;
    private final RoleRepositoryPort roleRepositoryPort;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepositoryPort userRepositoryPort, RoleRepositoryPort roleRepositoryPort, PasswordEncoder passwordEncoder) {
        this.userRepositoryPort = userRepositoryPort;
        this.roleRepositoryPort = roleRepositoryPort;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public User createUser(String email, String nombre, String plainPassword, String roleName) {
        userRepositoryPort.findByEmail(email).ifPresent(user -> {
            throw new UserAlreadyExistsException("El correo electrónico " + email + " ya está registrado.");
        });

        Role role = roleRepositoryPort.findByName(roleName)
            .orElseThrow(() -> new IllegalArgumentException("El rol '" + roleName + "' no es válido."));

        String hashedPassword = passwordEncoder.encode(plainPassword);

        User newUser = new User(email, nombre, hashedPassword, role.getId());

        return userRepositoryPort.save(newUser);
    }
}