package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Veterinario;


@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{
    Cliente findByNombre(String nombre);
    Cliente findByCedula(String cedula);
    List<Cliente> findByVeterinario(Veterinario veterinario);
}