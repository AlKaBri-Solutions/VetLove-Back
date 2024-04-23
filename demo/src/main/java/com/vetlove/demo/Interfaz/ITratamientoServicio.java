package com.vetlove.demo.Interfaz;

import com.vetlove.demo.Entidad.Tratamiento;

public interface ITratamientoServicio {
    public Tratamiento searchById(Long id);
    public int countTratamientosActivos();
    public int countTratamientosRealizados();
}
