package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Fecha;

@Repository
public interface FechaRepositorio extends JpaRepository<Fecha, Integer> {
    public Fecha findByFecha(String fecha);
}
