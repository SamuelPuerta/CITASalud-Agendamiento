package com.citasalud.agendamiento.infrastructure.out.persistence.repository;

import com.citasalud.agendamiento.infrastructure.out.persistence.entity.AvailableSlotInstanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID; 

public interface SpringDataJpaAvailableSlotInstanceRepository extends JpaRepository<AvailableSlotInstanceEntity, UUID> {
}