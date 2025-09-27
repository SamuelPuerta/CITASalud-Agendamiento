package com.citasalud.agendamiento.infrastructure.out.persistence.adapter;

import com.citasalud.agendamiento.domain.model.User;
import com.citasalud.agendamiento.domain.ports.out.UserRepositoryPort;
import com.citasalud.agendamiento.infrastructure.out.persistence.entity.UserEntity;
import com.citasalud.agendamiento.infrastructure.out.persistence.mapper.UserMapper;
import com.citasalud.agendamiento.infrastructure.out.persistence.repository.SpringDataJpaUserRepository;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class JpaUserRepositoryAdapter implements UserRepositoryPort {
    private final SpringDataJpaUserRepository userRepository;
    private final UserMapper userMapper;

    public JpaUserRepositoryAdapter(SpringDataJpaUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = userMapper.toEntity(user);
        UserEntity savedEntity = userRepository.save(userEntity);
        return userMapper.toDomainModel(savedEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDomainModel);
    }
}