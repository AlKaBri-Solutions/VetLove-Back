package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Prioridad {
    @Id
    @GeneratedValue
    Long idPrioridad;
    String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "prioridad")
    List<Enfermedad> enfermedades = new ArrayList<>();

    public Prioridad() {

    }

    public Prioridad(String nombre) {
        this.nombre = nombre;
    }

    public Prioridad(Long idPrioridad, String nombre) {
        this.idPrioridad = idPrioridad;
        this.nombre = nombre;
    }

    public Long getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(Long idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Enfermedad> getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(List<Enfermedad> enfermedades) {
        this.enfermedades = enfermedades;
    }

    
}