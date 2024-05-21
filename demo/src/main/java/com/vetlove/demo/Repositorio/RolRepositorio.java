package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetlove.demo.Entidad.Rol;
import java.util.Optional;


public interface RolRepositorio extends JpaRepository<Rol, Long> {
    Optional<Rol> findByName(String name);
}
