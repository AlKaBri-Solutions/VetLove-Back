package com.vetlove.demo.Servicio;

import org.springframework.beans.factory.annotation.Autowired;

import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.Interfaz.ITratamientoServicio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;

public class TratamientoServicio implements ITratamientoServicio{
    @Autowired
    private TratamientoRepositorio repoTratamiento;

    @Override
    public Tratamiento searchById(Long id) {
        return repoTratamiento.findById(id).orElse(null);
    }


}
