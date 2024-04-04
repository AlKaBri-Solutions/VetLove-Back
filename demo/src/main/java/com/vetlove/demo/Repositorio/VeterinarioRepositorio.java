package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Veterinario;

@Repository
public interface VeterinarioRepositorio extends JpaRepository<Veterinario, Long>{
    
}