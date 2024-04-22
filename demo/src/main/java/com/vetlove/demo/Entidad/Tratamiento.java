package com.vetlove.demo.Entidad;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tratamiento {
    @Id
    @GeneratedValue
    Long idTratamiento;
    Date fechaInicio;
    Date fechaFin;
    float costo;
    boolean medicamentoAplicado;

    @ManyToOne
    Mascota mascota;
    
    @ManyToOne
    Medicamento medicamento;
    
    public Tratamiento() {
        
    }

    public Tratamiento(Date fechaInicio, Date fechaFin, float costo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
    }

    public Tratamiento(Long idTratamiento, Date fechaInicio, Date fechaFin, float costo) {
        this.idTratamiento = idTratamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
    }

    public Long getIdTratamiento() {
        return idTratamiento;
    }

    public void setIdTratamiento(Long idTratamiento) {
        this.idTratamiento = idTratamiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public boolean isMedicamentoAplicado() {
        return medicamentoAplicado;
    }

    public void setMedicamentoAplicado(boolean medicamentoAplicado) {
        this.medicamentoAplicado = medicamentoAplicado;
    }

    

    
}