package com.citasalud.agendamiento.infrastructure.out.persistence.mapper;

import com.citasalud.agendamiento.domain.model.Appointment;
import com.citasalud.agendamiento.infrastructure.out.persistence.entity.AppointmentEntity;
import org.springframework.stereotype.Component;

@Component
public class AppointmentMapper {

    public AppointmentEntity toEntity(Appointment appointment) {
        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(appointment.getId());
        entity.setProfessionalId(appointment.getProfessionalId());
        entity.setSiteId(appointment.getSiteId());
        entity.setAffiliateId(appointment.getAffiliateId());
        entity.setStartAt(appointment.getStartAt());
        entity.setEndAt(appointment.getEndAt());
        entity.setStatus(appointment.getStatus());
        entity.setAvailableSlotInstanceId(appointment.getAvailableSlotInstanceId());
        return entity;
    }

    public Appointment toDomainModel(AppointmentEntity entity) {
        Appointment model = new Appointment(
            entity.getProfessionalId(),
            entity.getSiteId(),
            entity.getAffiliateId(),
            entity.getStartAt(),
            entity.getEndAt(),
            entity.getStatus(),
            entity.getAvailableSlotInstanceId()
        );
        model.setId(entity.getId());
        return model;
    }
}