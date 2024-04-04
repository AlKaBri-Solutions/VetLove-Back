package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;

@Repository
public interface MascotaRepositorio extends JpaRepository<Mascota, Long> {
    List<Mascota> findByDueno(Cliente dueno);
    
}