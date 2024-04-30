package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Especialidad;
import com.vetlove.demo.Interfaz.IEspecialidadServicio;
import com.vetlove.demo.Repositorio.EspecialidadRepositorio;

@Service
public class EspecialidadServicio implements IEspecialidadServicio{

    @Autowired
    private EspecialidadRepositorio especialidadRepositorio;

    @Override
    public Especialidad findByNombre(String nombre) {
        return especialidadRepositorio.findByNombre(nombre);
    }

    @Override
    public List<Especialidad> findAll() {
        return especialidadRepositorio.findAll();
    }
    
}
