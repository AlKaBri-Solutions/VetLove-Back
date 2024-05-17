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
public class Medicamento {
    @Id
    @GeneratedValue
    Long idMedicamento;
    String nombre;
    float costo;
    float precio;
    int unidades;
    int vendidas;

    @JsonIgnore
    @OneToMany(mappedBy = "medicamento")
    List<Tratamiento> tratamientos = new ArrayList<>();

    @ManyToOne
    Enfermedad enfermedad;

    public Medicamento(float costo, float precio, int unidades, int vendidas) {
        this.costo = costo;
        this.precio = precio;
        this.unidades = unidades;
        this.vendidas = vendidas;
    }

    public Medicamento(Long idMedicamento, float costo, float precio, int unidades, int vendidas) {
        this.idMedicamento = idMedicamento;
        this.costo = costo;
        this.precio = precio;
        this.unidades = unidades;
        this.vendidas = vendidas;
    }
}