package com.citasalud.agendamiento.domain.ports.in;

import com.citasalud.agendamiento.domain.model.Appointment;
import java.util.UUID;

public interface ScheduleAppointmentUseCase {
    Appointment scheduleAppointment(UUID availableSlotInstanceId, UUID affiliateId);
}