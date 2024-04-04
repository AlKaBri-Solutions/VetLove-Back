package com.vetlove.demo.Interfaz;

import java.util.Collection;

import com.vetlove.demo.Entidad.EstadoMas;

public interface IEstadoMasServicio {
    public EstadoMas SearchById(Long id);
    public EstadoMas SearchByName(String name);
    public Collection<EstadoMas> SearchAll();
}