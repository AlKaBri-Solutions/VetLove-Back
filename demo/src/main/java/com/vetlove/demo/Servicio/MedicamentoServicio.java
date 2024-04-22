package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Enfermedad;
import com.vetlove.demo.Entidad.Medicamento;
import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.Interfaz.IMedicamentoServicio;
import com.vetlove.demo.Repositorio.MedicamentoRepositorio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;

@Service
public class MedicamentoServicio implements IMedicamentoServicio {

    @Autowired
    private TratamientoRepositorio repoTratamiento;

    @Autowired
    private MedicamentoRepositorio repoMedicamento;

    @Override
    public int aplicarMedicamento(Tratamiento tratamiento) {
        Medicamento medicamento = tratamiento.getMedicamento();
        if (medicamento.getUnidades() < 1) {
            return -1;
        } else {
            medicamento.setVendidas(medicamento.getVendidas() + 1);
            medicamento.setUnidades(medicamento.getUnidades() - 1);
            repoMedicamento.save(medicamento);
            tratamiento.setMedicamentoAplicado(true);
            repoTratamiento.save(tratamiento);
            return 1;
        }
    }

    @Override
    public Medicamento getMedicamentoByNombre(String nombre) {
        return repoMedicamento.findByNombre(nombre);
    }

    @Override
    public List<Medicamento> getMedicamentosSimilares(Medicamento medicamento) {
        Enfermedad enfermedad = medicamento.getEnfermedad();
        return repoMedicamento.findByEnfermedad(enfermedad);
    }

    @Override
    public int cambiarMedicamento(Tratamiento tratamiento) {
        List<Medicamento> alternativas = getMedicamentosSimilares(tratamiento.getMedicamento());
        if (alternativas.isEmpty()) {
            return -1;
        } 
        boolean flag = false;
        for (Medicamento medicamento : alternativas) {
            if (alternativas.get(0).getUnidades() < 1)
                flag = true;
        }
        if (!flag){
            Medicamento medicamento = alternativas.get(0);
            tratamiento.setMedicamento(medicamento);
            repoTratamiento.save(tratamiento);
            return 1;
        }
        else {
            return -1;
        }
    }

}
