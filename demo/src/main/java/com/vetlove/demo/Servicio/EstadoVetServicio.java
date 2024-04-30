package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.EstadoVet;
import com.vetlove.demo.Interfaz.IEstadoVetServicio;
import com.vetlove.demo.Repositorio.EstadoVetRepositorio;

@Service
public class EstadoVetServicio implements IEstadoVetServicio{

    @Autowired
    private EstadoVetRepositorio repoEstadoVet;

    @Override
    public EstadoVet SearchById(Long id) {
        return repoEstadoVet.findById(id).orElse(null);
    }

    @Override
    public EstadoVet SearchByName(String name) {
        return repoEstadoVet.findByNombre(name);
    }

    @Override
    public List<EstadoVet> SearchAll() {
        return repoEstadoVet.findAll();
    }
    
}
