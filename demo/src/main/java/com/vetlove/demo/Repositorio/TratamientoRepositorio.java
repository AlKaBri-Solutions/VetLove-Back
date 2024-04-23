package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Tratamiento;


@Repository
public interface TratamientoRepositorio extends JpaRepository<Tratamiento, Long>{
    List<Tratamiento> findByMascota(Mascota mascota);
}