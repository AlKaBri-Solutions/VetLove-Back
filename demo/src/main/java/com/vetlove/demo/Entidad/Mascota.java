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
public class Mascota {
    @Id
    @GeneratedValue
    Long id;
    String nombre;
    String raza;
    Integer edad;
    Integer peso;
    String foto; // Url de la imagen

    @ManyToOne
    Cliente dueno;

    @ManyToOne
    EstadoMas estado;

    @JsonIgnore
    @OneToMany(mappedBy = "mascota")
    List<Tratamiento> tratamientos = new ArrayList<>();

    public Mascota(String nombre, String raza, Integer edad, Integer peso, String foto) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.foto = foto;
    }

    public Mascota(Long id, String nombre, String raza, Integer edad, Integer peso, String foto) {
        this.id = id;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.foto = foto;
    }
}