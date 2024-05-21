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
public class EstadoMas {
    @Id
    @GeneratedValue
    Long id;
    String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    List<Mascota> mascotas = new ArrayList<>();

    public EstadoMas(String nombre) {
        this.nombre = nombre;
    }

    public EstadoMas(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
}