package com.citasalud.agendamiento.domain.model;

import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String nombre;
    private String hashedPassword; // Importante: en el dominio manejamos el password ya hasheado
    private Short roleId;

    public User(String email, String nombre, String hashedPassword, Short roleId) {
        this.email = email;
        this.nombre = nombre;
        this.hashedPassword = hashedPassword;
        this.roleId = roleId;
    }

    // Getters y Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getHashedPassword() { return hashedPassword; }
    public void setHashedPassword(String hashedPassword) { this.hashedPassword = hashedPassword; }
    public Short getRoleId() { return roleId; }
    public void setRoleId(Short roleId) { this.roleId = roleId; }
}