package com.vetlove.demo.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
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
    @Transient
    String contrasenia;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private UserEntity userEntity;
   
    public Administrador(String cedula, String contrasenia) {
        this.cedula = cedula;
        this.contrasenia = contrasenia;
    }
}