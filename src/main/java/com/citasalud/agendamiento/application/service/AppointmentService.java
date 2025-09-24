package com.citasalud.agendamiento.application.service;

import com.citasalud.agendamiento.domain.exception.SlotNotAvailableException;
import com.citasalud.agendamiento.domain.exception.SlotNotFoundException;
import com.citasalud.agendamiento.domain.model.Appointment;
import com.citasalud.agendamiento.domain.model.AvailableSlotInstance;
import com.citasalud.agendamiento.domain.ports.in.ScheduleAppointmentUseCase;
import com.citasalud.agendamiento.domain.ports.out.AppointmentRepositoryPort;
import com.citasalud.agendamiento.domain.ports.out.AvailableSlotInstanceRepositoryPort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class AppointmentService implements ScheduleAppointmentUseCase {

    private final AppointmentRepositoryPort appointmentRepositoryPort;
    private final AvailableSlotInstanceRepositoryPort availableSlotInstanceRepositoryPort;

    public AppointmentService(AppointmentRepositoryPort appointmentRepositoryPort, AvailableSlotInstanceRepositoryPort availableSlotInstanceRepositoryPort) {
        this.appointmentRepositoryPort = appointmentRepositoryPort;
        this.availableSlotInstanceRepositoryPort = availableSlotInstanceRepositoryPort;
    }

    @Override
    @Transactional
    public Appointment scheduleAppointment(UUID availableSlotInstanceId, UUID affiliateId) {
        AvailableSlotInstance slot = availableSlotInstanceRepositoryPort.findById(availableSlotInstanceId)
            .orElseThrow(() -> new SlotNotFoundException("El slot seleccionado no existe."));

        if (!"available".equalsIgnoreCase(slot.getStatus())) {
            throw new SlotNotAvailableException("Este slot ya no está disponible.");
        }

        slot.setStatus("booked");
        availableSlotInstanceRepositoryPort.save(slot);

        Appointment newAppointment = new Appointment(
            slot.getProfessionalId(),
            slot.getSiteId(),
            affiliateId,
            slot.getStartAt(),
            slot.getEndAt(),
            "scheduled",
            slot.getId()
        );

        return appointmentRepositoryPort.save(newAppointment);
    }
}