package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstadoVet {
    @Id
    @GeneratedValue
    Long idEstado;
    String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "estado")
    List<Veterinario> veterinario = new ArrayList<>();

    public EstadoVet(String nombre) {
        this.nombre = nombre;
    }

    public EstadoVet(String nombre, List<Veterinario> veterinario) {
        this.nombre = nombre;
        this.veterinario = veterinario;
    }    
}