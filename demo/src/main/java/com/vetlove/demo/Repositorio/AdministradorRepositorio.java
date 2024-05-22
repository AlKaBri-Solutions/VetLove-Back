package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Administrador;

@Repository
public interface AdministradorRepositorio extends JpaRepository<Administrador, Long>{
    Administrador findByCedula(String cedula);
}