package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Veterinario {
    @Id
    @GeneratedValue
    Long idVeterinario;
    String cedula;
    String nombre;
    String contrasenia;
    String fotoUrl;

    @ManyToOne
    Especialidad especialidad;

    @JsonIgnore
    @OneToMany(mappedBy = "veterinario")
    List<Cliente> clientes = new ArrayList<>();

    
    @ManyToOne
    EstadoVet estado;

    public Veterinario(String cedula, String nombre, String contrasenia, String fotoUrl) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.fotoUrl = fotoUrl;
    }

    public Veterinario(Long idVeterinario, String cedula, String nombre, String contrasenia, String fotoUrl) {
        this.idVeterinario = idVeterinario;
        this.cedula = cedula;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.fotoUrl = fotoUrl;
    }  
}