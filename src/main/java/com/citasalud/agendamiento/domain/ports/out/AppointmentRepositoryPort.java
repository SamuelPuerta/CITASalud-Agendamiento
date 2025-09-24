package com.citasalud.agendamiento.domain.ports.out;

import com.citasalud.agendamiento.domain.model.Appointment;

public interface AppointmentRepositoryPort {
    Appointment save(Appointment appointment);
}