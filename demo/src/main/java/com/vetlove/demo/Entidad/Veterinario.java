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

    public Veterinario() {
    
    }

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

    public Long getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Long idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public EstadoVet getEstado() {
        return estado;
    }

    public void setEstado(EstadoVet estado) {
        this.estado = estado;
    }



    
}