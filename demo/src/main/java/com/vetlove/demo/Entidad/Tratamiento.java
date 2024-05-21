package com.vetlove.demo.Entidad;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Tratamiento {
    @Id
    @GeneratedValue
    Long idTratamiento;
    @Temporal(TemporalType.DATE)
    Date fechaInicio;
    @Temporal(TemporalType.DATE)
    Date fechaFin;
    float costo;
    boolean medicamentoAplicado;

    @ManyToOne
    Mascota mascota;
    
    @ManyToOne
    Medicamento medicamento;

    public Tratamiento(Date fechaInicio, Date fechaFin, float costo, boolean medicamentoAplicado) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
        this.medicamentoAplicado = medicamentoAplicado;
    }

    public Tratamiento(Long idTratamiento, Date fechaInicio, Date fechaFin, float costo) {
        this.idTratamiento = idTratamiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
    }
}