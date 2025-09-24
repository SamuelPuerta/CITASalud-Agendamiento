package com.citasalud.agendamiento.domain.ports.out;

import com.citasalud.agendamiento.domain.model.AvailableSlotInstance;
import java.util.Optional;
import java.util.UUID;

public interface AvailableSlotInstanceRepositoryPort {
    Optional<AvailableSlotInstance> findById(UUID id);
    AvailableSlotInstance save(AvailableSlotInstance slotInstance);
}