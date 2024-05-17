package com.vetlove.demo.Entidad;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Fecha {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "fecha")
    private List<Reserva> reservas;

    private String fecha;
    

    public Fecha(String fecha) {
        this.fecha = fecha;
    }

    public Fecha(Long id, String fecha) {
        this.id = id;
        this.fecha = fecha;
    }    
}
