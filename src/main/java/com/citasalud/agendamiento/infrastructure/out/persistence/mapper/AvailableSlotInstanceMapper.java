package com.citasalud.agendamiento.infrastructure.out.persistence.mapper;

import com.citasalud.agendamiento.domain.model.AvailableSlotInstance;
import com.citasalud.agendamiento.infrastructure.out.persistence.entity.AvailableSlotInstanceEntity;
import org.springframework.stereotype.Component;

@Component
public class AvailableSlotInstanceMapper {

    public AvailableSlotInstanceEntity toEntity(AvailableSlotInstance model) {
        AvailableSlotInstanceEntity entity = new AvailableSlotInstanceEntity();
        entity.setId(model.getId());
        entity.setStartAt(model.getStartAt());
        entity.setEndAt(model.getEndAt());
        entity.setStatus(model.getStatus());
        return entity;
    }
    
    public AvailableSlotInstance toDomainModel(AvailableSlotInstanceEntity entity) {
        AvailableSlotInstance model = new AvailableSlotInstance();
        model.setId(entity.getId());
        model.setStartAt(entity.getStartAt());
        model.setEndAt(entity.getEndAt());
        model.setStatus(entity.getStatus());
        return model;
    }
}