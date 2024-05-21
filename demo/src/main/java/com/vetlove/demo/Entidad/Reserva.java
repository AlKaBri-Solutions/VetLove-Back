package com.vetlove.demo.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    Hora hora;

    @ManyToOne
    Fecha fecha;

    boolean disponible;

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

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}