package com.vetlove.demo.Interfaz;

import com.vetlove.demo.Entidad.EstadoVet;

public interface IEstadoVetServicio {
    public EstadoVet SearchById(Long id);
    public EstadoVet SearchByName(String name);
}
