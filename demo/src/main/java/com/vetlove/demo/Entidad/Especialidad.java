package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Especialidad {
    @Id
    @GeneratedValue
    Long idEspecialidad;
    String nombre;
    
    @JsonIgnore
    @OneToMany(mappedBy = "especialidad")
    List<Veterinario> veterinarios = new ArrayList<>();

    public Especialidad(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad(Long idEspecialidad, String nombre) {
        this.idEspecialidad = idEspecialidad;
        this.nombre = nombre;
    }
}