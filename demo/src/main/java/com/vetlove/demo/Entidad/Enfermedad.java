package com.vetlove.demo.Entidad;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Enfermedad {
    @Id
    @GeneratedValue
    Long idEnfermedad;
    String nombre;

    @JsonIgnore
    @OneToMany(mappedBy = "enfermedad")
    List<Medicamento> medicamentos = new ArrayList<>();
    
    @ManyToOne
    Prioridad prioridad;

    public Enfermedad(String nombre) {
        this.nombre = nombre;
    }

    public Enfermedad(Long idEnfermedad, String nombre) {
        this.idEnfermedad = idEnfermedad;
        this.nombre = nombre;
    }
}