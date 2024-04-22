package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Enfermedad {
    @Id
    @GeneratedValue
    Long idEnfermedad;
    String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "enfermedad")
    List<Medicamento> medicamentos = new ArrayList<>();
    
    @ManyToOne
    Prioridad prioridad;

    public Enfermedad() {

    }

    public Enfermedad(String nombre) {
        this.nombre = nombre;
    }

    public Enfermedad(Long idEnfermedad, String nombre) {
        this.idEnfermedad = idEnfermedad;
        this.nombre = nombre;
    }

    public Long getIdEnfermedad() {
        return idEnfermedad;
    }

    public void setIdEnfermedad(Long idEnfermedad) {
        this.idEnfermedad = idEnfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    


}