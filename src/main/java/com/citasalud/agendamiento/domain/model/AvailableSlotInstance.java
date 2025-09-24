package com.citasalud.agendamiento.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public class AvailableSlotInstance {

    private UUID id;
    private UUID professionalId; // Necesario para la lógica de negocio
    private UUID siteId;         // Necesario para la lógica de negocio
    private OffsetDateTime startAt;
    private OffsetDateTime endAt;
    private String status;

    // Getters y Setters...
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getProfessionalId() { return professionalId; }
    public void setProfessionalId(UUID professionalId) { this.professionalId = professionalId; }
    public UUID getSiteId() { return siteId; }
    public void setSiteId(UUID siteId) { this.siteId = siteId; }
    public OffsetDateTime getStartAt() { return startAt; }
    public void setStartAt(OffsetDateTime startAt) { this.startAt = startAt; }
    public OffsetDateTime getEndAt() { return endAt; }
    public void setEndAt(OffsetDateTime endAt) { this.endAt = endAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}