package com.vetlove.demo.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Administrador {
    @Id
    @GeneratedValue
    Long id;

    String cedula;
    String contrasenia;
    
    public Administrador() {
    }
    
    public Administrador(String cedula, String contrasenia) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    
}