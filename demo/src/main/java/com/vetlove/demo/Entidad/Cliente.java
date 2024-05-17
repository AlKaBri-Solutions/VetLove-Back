package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue
    Long id;
    String cedula;
    String nombre;
    String correo;
    String celular;

    @ManyToOne
    Veterinario veterinario;
    
    @JsonIgnore
    @OneToMany(mappedBy = "dueno", fetch = FetchType.EAGER)
    List<Mascota> mascotas = new ArrayList<>();

    public Cliente(String cedula, String nombre, String correo, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
    }

    public Cliente(Long id, String cedula, String nombre, String correo, String celular) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
    }   
}