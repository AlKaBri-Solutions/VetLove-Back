package com.vetlove.demo.Interfaz;

import java.util.List;

import com.vetlove.demo.Entidad.Especialidad;

public interface IEspecialidadServicio {
    public Especialidad findByNombre(String nombre);
    public List<Especialidad> findAll();
}
