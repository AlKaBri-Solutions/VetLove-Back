package com.vetlove.demo.EntidadRequest;

import com.vetlove.demo.Entidad.Enfermedad;

public class AddTratamientoRequest {
    private Enfermedad enfermedad;
    private String cedula;
    private String nombre;
    private int duracion;

    

    public AddTratamientoRequest(Enfermedad enfermedad, String cedula, String nombre, int duracion) {
        this.enfermedad = enfermedad;
        this.cedula = cedula;
        this.nombre = nombre;
        this.duracion = duracion;
    }
    public Enfermedad getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad(Enfermedad enfermedad) {
        this.enfermedad = enfermedad;
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
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    
}
