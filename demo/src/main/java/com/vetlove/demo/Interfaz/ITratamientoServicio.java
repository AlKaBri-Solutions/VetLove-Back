package com.vetlove.demo.Interfaz;

import java.util.List;

import com.vetlove.demo.Entidad.Tratamiento;

public interface ITratamientoServicio {
    public Tratamiento searchById(Long id);
    public List<Tratamiento> SearchAll();
}
