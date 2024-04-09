package com.vetlove.demo.Servicio;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.EstadoMas;
import com.vetlove.demo.Interfaz.IEstadoMasServicio;
import com.vetlove.demo.Repositorio.EstadoMasRepositorio;

@Service
public class EstadoMasServicio implements IEstadoMasServicio{
    @Autowired
    EstadoMasRepositorio repoEstadoMas;

    @Override
    public EstadoMas SearchById(Long id) {
        return repoEstadoMas.findById(id).get();
    }

    @Override
    public EstadoMas SearchByName(String name){
        return repoEstadoMas.findByNombre(name);
    }

    @Override
    public Collection<EstadoMas> SearchAll(){
        return repoEstadoMas.findAll();
    }
}