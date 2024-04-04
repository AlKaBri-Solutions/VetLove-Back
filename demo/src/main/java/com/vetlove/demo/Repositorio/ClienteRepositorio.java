package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Cliente;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    Cliente findByNombre(String nombre);
    Cliente findByCedula(String cedula);
}