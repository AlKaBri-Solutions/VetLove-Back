package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Fecha;
import com.vetlove.demo.Entidad.Reserva;

@Repository
public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {
    List<Reserva> findByDisponible(boolean disponible);
    List<Reserva> findByFecha(Fecha fecha);
}