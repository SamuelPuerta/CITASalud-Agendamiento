package com.citasalud.agendamiento.infrastructure.out.persistence.repository;

import com.citasalud.agendamiento.infrastructure.out.persistence.entity.AvailabilitySlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface SpringDataJpaAvailabilitySlotRepository extends JpaRepository<AvailabilitySlotEntity, UUID> {
}