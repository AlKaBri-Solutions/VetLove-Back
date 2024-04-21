package com.vetlove.demo.EntidadRequest;

import com.vetlove.demo.Entidad.Veterinario;

public class AddVeterinarioRequest {
    private Veterinario veterinario;
    private String especialidad;
    
    public Veterinario getVeterinario() {
        return veterinario;
    }
    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
