package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.Interfaz.ITratamientoServicio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;

@Service
public class TratamientoServicio implements ITratamientoServicio{
    @Autowired
    private TratamientoRepositorio repoTratamiento;

    @Override
    public Tratamiento searchById(Long id) {
        return repoTratamiento.findById(id).orElse(null);
    }

    @Override
    public int countTratamientosActivos() {
        List<Tratamiento> tratamientos = repoTratamiento.findAll();
        int count = 0;
        for (Tratamiento t : tratamientos) {
            if (!t.isMedicamentoAplicado()) {
                count++;
            }
        }
        return count;
    }

    @Override
    public int countTratamientosRealizados() {
        List<Tratamiento> tratamientos = repoTratamiento.findAll();
        int count = 0;
        for (Tratamiento t : tratamientos) {
            if (t.isMedicamentoAplicado()) {
                count++;
            }
        }
        return count;
    }

}
