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
public class Prioridad {
    @Id
    @GeneratedValue
    Long idPrioridad;
    String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "prioridad")
    List<Enfermedad> enfermedades = new ArrayList<>();

    public Prioridad(String nombre) {
        this.nombre = nombre;
    }

    public Prioridad(Long idPrioridad, String nombre) {
        this.idPrioridad = idPrioridad;
        this.nombre = nombre;
    }
}