package com.vetlove.demo.EntidadRequest;

import com.vetlove.demo.Entidad.Mascota;

public class AddMascotaRequest {
    private Mascota mascota;
    private String cedula;
    public Mascota getMascota() {
        return mascota;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
}
