package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class EstadoMas {
    @Id
    @GeneratedValue
    Long id;
    String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    List<Mascota> mascotas = new ArrayList<>();

    public EstadoMas() {
    
    }

    public EstadoMas(String nombre) {
        this.nombre = nombre;
    }

    public EstadoMas(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }


}