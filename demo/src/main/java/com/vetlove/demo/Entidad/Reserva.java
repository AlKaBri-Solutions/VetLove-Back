package com.vetlove.demo.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Reserva {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Hora hora;

    @ManyToOne
    Fecha fecha;

    boolean disponible;

    public Reserva(){

    }

    public Reserva(Hora hora, Fecha fecha, boolean disponible){
        this.hora = hora;
        this.fecha = fecha;
        this.disponible = disponible;
    }

    public Reserva(Long id, Hora hora, Fecha fecha, boolean disponible) {
        this.id = id;
        this.hora = hora;
        this.fecha = fecha;
        this.disponible = disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
