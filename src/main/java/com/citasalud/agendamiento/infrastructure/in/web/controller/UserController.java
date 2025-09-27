package com.citasalud.agendamiento.infrastructure.in.web.controller;

import com.citasalud.agendamiento.domain.model.User;
import com.citasalud.agendamiento.domain.ports.in.CreateUserUseCase;
import com.citasalud.agendamiento.infrastructure.in.web.dto.CreateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final CreateUserUseCase createUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase) {
        this.createUserUseCase = createUserUseCase;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
        User createdUser = createUserUseCase.createUser(
            request.getEmail(),
            request.getNombre(),
            request.getPassword(),
            request.getRoleName()
        );
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}