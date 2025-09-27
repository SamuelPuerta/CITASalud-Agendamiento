package com.citasalud.agendamiento.domain.ports.out;

import com.citasalud.agendamiento.domain.model.User;
import java.util.Optional;

public interface UserRepositoryPort {
    User save(User user);
    Optional<User> findByEmail(String email);
}