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
public class Hora {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "hora")
    private List<Reserva> reservas;

    private String horario;

    public Hora(String horario) {
        this.horario = horario;
    }

    public Hora(Long id, String horario) {
        this.id = id;
        this.horario = horario;
    }
}
