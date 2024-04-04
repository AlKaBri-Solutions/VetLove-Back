package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.EstadoMas;

@Repository
public interface EstadoMasRepositorio extends JpaRepository<EstadoMas, Long>{
    EstadoMas findByNombre(String name);
}