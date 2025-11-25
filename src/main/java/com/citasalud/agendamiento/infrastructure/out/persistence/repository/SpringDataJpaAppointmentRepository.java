package com.citasalud.agendamiento.infrastructure.out.persistence.repository;

import com.citasalud.agendamiento.infrastructure.out.persistence.entity.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;

public interface SpringDataJpaAppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {
    List<AppointmentEntity> findAllByAffiliateId(UUID affiliateId);
}