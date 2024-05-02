package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Enfermedad;
import com.vetlove.demo.Interfaz.IEnfermedadServicio;
import com.vetlove.demo.Repositorio.EnfermedadRepositorio;

@Service
public class EnfermedadServicio implements IEnfermedadServicio{

    @Autowired
    private EnfermedadRepositorio repoEnfermedad;

    @Override
    public List<Enfermedad> searchAll() {
        return repoEnfermedad.findAll();
    }
    
}
