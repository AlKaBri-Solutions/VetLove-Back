package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.EstadoVet;

@Repository
public interface EstadoVetRepositorio extends JpaRepository<EstadoVet, Long>{
    
}