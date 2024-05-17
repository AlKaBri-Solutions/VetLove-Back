package com.vetlove.demo.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Administrador {
    @Id
    @GeneratedValue
    Long id;

    String cedula;
    String contrasenia;
   
    public Administrador(String cedula, String contrasenia) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
    }
}