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
public class Medicamento {
    @Id
    @GeneratedValue
    Long idMedicamento;
    String nombre;
    float costo;
    float precio;
    int unidades;
    int vendidas;

    @JsonIgnore
    @OneToMany(mappedBy = "medicamento")
    List<Tratamiento> tratamientos = new ArrayList<>();

    @JsonIgnore
    @ManyToOne
    Enfermedad enfermedad;

    public Medicamento() {

    }

    public Medicamento(float costo, float precio, int unidades, int vendidas) {
        this.costo = costo;
        this.precio = precio;
        this.unidades = unidades;
        this.vendidas = vendidas;
    }

    public Medicamento(Long idMedicamento, float costo, float precio, int unidades, int vendidas) {
        this.idMedicamento = idMedicamento;
        this.costo = costo;
        this.precio = precio;
        this.unidades = unidades;
        this.vendidas = vendidas;
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public int getVendidas() {
        return vendidas;
    }

    public void setVendidas(int vendidas) {
        this.vendidas = vendidas;
    }

    public Enfermedad getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamientos) {
        this.tratamientos = tratamientos;
    }

    

    
}