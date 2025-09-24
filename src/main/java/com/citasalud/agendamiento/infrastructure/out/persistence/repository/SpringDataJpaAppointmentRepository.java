package com.citasalud.agendamiento.infrastructure.out.persistence.repository;

import com.citasalud.agendamiento.infrastructure.out.persistence.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SpringDataJpaAppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
}