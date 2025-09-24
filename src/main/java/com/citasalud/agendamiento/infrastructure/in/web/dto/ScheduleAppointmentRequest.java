package com.citasalud.agendamiento.infrastructure.in.web.dto;

import java.util.UUID;

public class ScheduleAppointmentRequest {
    private UUID availableSlotInstanceId;
    private UUID affiliateId;

    // Getters y Setters
    public UUID getAvailableSlotInstanceId() { return availableSlotInstanceId; }
    public void setAvailableSlotInstanceId(UUID availableSlotInstanceId) { this.availableSlotInstanceId = availableSlotInstanceId; }
    public UUID getAffiliateId() { return affiliateId; }
    public void setAffiliateId(UUID affiliateId) { this.affiliateId = affiliateId; }
}