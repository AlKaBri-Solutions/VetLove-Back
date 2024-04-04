package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class EstadoVet {
    @Id
    @GeneratedValue
    Long idEstado;
    String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    List<Veterinario> veterinario = new ArrayList<>();

    public EstadoVet() {
    
    }
    
    public EstadoVet(String nombre) {
        this.nombre = nombre;
    }

    public EstadoVet(String nombre, List<Veterinario> veterinario) {
        this.nombre = nombre;
        this.veterinario = veterinario;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Veterinario> getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(List<Veterinario> veterinario) {
        this.veterinario = veterinario;
    }

    

    
}