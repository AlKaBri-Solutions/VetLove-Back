package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Veterinario;

@Repository
public interface VeterinarioRepositorio extends JpaRepository<Veterinario, Long>{
    Veterinario findByCedula(String cedula);

    @Query(value = "SELECT COUNT(*) \r\n" + //
    "FROM VETERINARIO \r\n" + //
    "WHERE ESTADO_ID_ESTADO = 1 \r\n"
    , nativeQuery = true)
    int findCountVeterinariosActivos();
    //SELECT COUNT(*) FROM VETERINARIO WHERE ESTADO_ID_ESTADO = 1

    @Query(value = "SELECT COUNT(*) \r\n" + //
    "FROM VETERINARIO \r\n" + //
    "WHERE ESTADO_ID_ESTADO = 2 \r\n"
    , nativeQuery = true)
    int findCountVeterinariosInactivos();
    //SELECT COUNT(*) FROM VETERINARIO WHERE ESTADO_ID_ESTADO = 2
}