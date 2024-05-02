package com.vetlove.demo.Servicio;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Medicamento;
import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.EntidadConsulta.TratamientosXEnfermedadLMConsulta;
import com.vetlove.demo.EntidadRequest.AddTratamientoRequest;
import com.vetlove.demo.Interfaz.ITratamientoServicio;
import com.vetlove.demo.Repositorio.ClienteRepositorio;
import com.vetlove.demo.Repositorio.EnfermedadRepositorio;
import com.vetlove.demo.Repositorio.MascotaRepositorio;
import com.vetlove.demo.Repositorio.MedicamentoRepositorio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;
import com.vetlove.demo.Repositorio.TratamientosXEnfermedadLMConsultaRepositorio;
import com.vetlove.demo.Repositorio.VeterinarioRepositorio;

@Service
public class TratamientoServicio implements ITratamientoServicio {
    @Autowired
    private TratamientoRepositorio repoTratamiento;

    @Autowired
    private TratamientosXEnfermedadLMConsultaRepositorio repoConsulta;

    @Autowired
    private MascotaRepositorio repoMascota;

    @Autowired
    private VeterinarioRepositorio repoVeterinario;

    @Autowired
    private MedicamentoRepositorio repoMedicamento;

    @Autowired
    private EnfermedadRepositorio repoEnfermedad;

    @Autowired
    private ClienteRepositorio repoCliente;

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

    @Override
    public List<Tratamiento> SearchAll() {
        return repoTratamiento.findAll();
    }

    @Override
    public int getCountTratamientosLastMonth() {
        return repoTratamiento.findCountTratamientosLastMonth();
    }

    @Override
    public List<TratamientosXEnfermedadLMConsulta> tratamientosXEnfermedadLastMonth() {
        return repoConsulta.findTratameintosXEnfermedadLastMonth();
    }

    @Override
    public List<Tratamiento> SearchAllByMascotaId(Long id) {
        Mascota mascota = repoMascota.findById(id).orElse(null);
        return repoTratamiento.findByMascota(mascota);
    }

    @Override
    public List<Tratamiento> SearchActivosByVeterinarioId(Long id) {
        return repoTratamiento.findByVeterinarioId(id);
    }

    @Override
    public int save(AddTratamientoRequest tratamiento) {
        Tratamiento t = new Tratamiento();
        LocalDate fechaInicio = LocalDate.now(); // Get the current date
        t.setFechaInicio(java.sql.Date.valueOf(fechaInicio));

        LocalDate fechaFin = fechaInicio.plusDays(tratamiento.getDuracion()); // Add the specified number of days
        t.setFechaFin(java.sql.Date.valueOf(fechaFin));

        Medicamento medicamento = repoMedicamento.findByEnfermedad(tratamiento.getEnfermedad()).get(0);
        t.setMedicamento(medicamento);
        t.setMedicamentoAplicado(false);
        t.setCosto(medicamento.getPrecio());
        for (Cliente cliente : repoCliente.findAll()) {
            if (cliente.getCedula().equals(tratamiento.getCedula())) {
                for (Mascota mascota : cliente.getMascotas()) {
                    if (mascota.getNombre().equals(tratamiento.getNombre())) {
                        t.setMascota(mascota);
                        repoTratamiento.save(t);
                        return 1;
                    }
                }
                return -1; // Retorna -1 si el cliente no tiene una mascota con ese nombre
            }
        }
        return -2; // Retorna -2 si el cliente no existe
    }

}
