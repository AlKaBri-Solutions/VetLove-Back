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
public class Mascota {
    @Id
    @GeneratedValue
    Long id;
    String nombre;
    String raza;
    Integer edad;
    Integer peso;
    String foto; // Url de la imagen

    @JsonIgnore
    @ManyToOne
    Cliente dueno;

    @ManyToOne
    EstadoMas estado;

    @JsonIgnore
    @OneToMany(mappedBy = "mascota")
    List<Tratamiento> tratamientos = new ArrayList<>();

    public Mascota() {

    }

    public Mascota(String nombre, String raza, Integer edad, Integer peso, String foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.foto = foto;
    }

    public Mascota(Long id, String nombre, String raza, Integer edad, Integer peso, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.foto = foto;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Cliente getDueno() {
        return dueno;
    }

    public void setDueno(Cliente dueno) {
        this.dueno = dueno;
    }

    public EstadoMas getEstado() {
        return estado;
    }

    public void setEstado(EstadoMas estado) {
        this.estado = estado;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    

}