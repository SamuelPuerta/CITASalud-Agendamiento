package com.citasalud.agendamiento.infrastructure.in.web.controller;

import com.citasalud.agendamiento.domain.model.Appointment;
import com.citasalud.agendamiento.domain.ports.in.ScheduleAppointmentUseCase;
import com.citasalud.agendamiento.infrastructure.in.web.dto.ScheduleAppointmentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    private final ScheduleAppointmentUseCase scheduleAppointmentUseCase;

    public AppointmentController(ScheduleAppointmentUseCase scheduleAppointmentUseCase) {
        this.scheduleAppointmentUseCase = scheduleAppointmentUseCase;
    }

    @PostMapping
    public ResponseEntity<Appointment> scheduleAppointment(@RequestBody ScheduleAppointmentRequest request) {
        Appointment createdAppointment = scheduleAppointmentUseCase.scheduleAppointment(
            request.getAvailableSlotInstanceId(),
            request.getAffiliateId()
        );
        
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }
}