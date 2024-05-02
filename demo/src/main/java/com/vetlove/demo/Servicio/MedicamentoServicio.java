package com.vetlove.demo.Servicio;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Enfermedad;
import com.vetlove.demo.Entidad.EstadoMas;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Medicamento;
import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.Interfaz.IMedicamentoServicio;
import com.vetlove.demo.Repositorio.EnfermedadRepositorio;
import com.vetlove.demo.Repositorio.EstadoMasRepositorio;
import com.vetlove.demo.Repositorio.MascotaRepositorio;
import com.vetlove.demo.Repositorio.MedicamentoRepositorio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;

@Service
public class MedicamentoServicio implements IMedicamentoServicio {

    @Autowired
    private TratamientoRepositorio repoTratamiento;

    @Autowired
    private MedicamentoRepositorio repoMedicamento;

    @Autowired
    private EstadoMasRepositorio repoEstadoMas;

    @Autowired
    private MascotaRepositorio repoMascota;

    @Autowired
    private EnfermedadRepositorio repoEnfermedad;


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
            EstadoMas estado = repoEstadoMas.findByNombre("De baja");
            Mascota mascota = tratamiento.getMascota();
            mascota.setEstado(estado);
            repoMascota.save(mascota);
            
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
        for (int i = 0; i < alternativas.size(); i++) {
            Medicamento medicamento = alternativas.get(i);
            if (medicamento.getUnidades() > 0) {
                Date inicio = tratamiento.getFechaInicio();
                Date fin = tratamiento.getFechaFin();
                long inMillis = inicio.getTime();
                inMillis += 86400000; // One day in milliseconds (24 * 60 * 60 * 1000)
                Date newInicio = new Date(inMillis);

                // Add one day to the fin date
                inMillis = fin.getTime();
                inMillis += 86400000;
                Date newFin = new Date(inMillis);
                tratamiento.setMedicamento(medicamento);
                tratamiento.setFechaInicio(newInicio);
                tratamiento.setFechaFin(newFin);
                repoTratamiento.save(tratamiento);
                return 1;
            }
        }
        return -1;
    }

    @Override
    public List<Medicamento> SearchAll() {
        return repoMedicamento.findAll();
    }

    @Override
    public double findVentasTotales() {
        return repoMedicamento.findVentasTotales();
    }

    @Override
    public double findGananciasTotales() {
        return repoMedicamento.findGananciasTotales();
    }

    @Override
    public List<Medicamento> findTopVendidos() {
        return repoMedicamento.findTopVendidos();
    }


}
