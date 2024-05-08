package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Hora;

@Repository
public interface HoraRepositorio extends JpaRepository<Hora, Long> {
    
}
