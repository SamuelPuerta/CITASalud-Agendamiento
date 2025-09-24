package com.citasalud.agendamiento.infrastructure.out.persistence.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "availability_slots")
public class AvailabilitySlotEntity {

    @Id
    private UUID id;

    @Column(name = "professional_id", nullable = false)
    private UUID professionalId;

    @Column(name = "site_id")
    private UUID siteId;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public UUID getProfessionalId() { return professionalId; }
    public void setProfessionalId(UUID professionalId) { this.professionalId = professionalId; }
    public UUID getSiteId() { return siteId; }
    public void setSiteId(UUID siteId) { this.siteId = siteId; }
}