package com.citasalud.agendamiento.domain.ports.in;

import com.citasalud.agendamiento.domain.model.Appointment;
import java.util.List;

public interface GetAppointmentHistoryUseCase {
    List<Appointment> getAppointmentHistory(String userEmail);
}