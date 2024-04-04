package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Especialidad;

@Repository
public interface EspecialidadRepositorio extends JpaRepository<Especialidad, Long>{
    
}