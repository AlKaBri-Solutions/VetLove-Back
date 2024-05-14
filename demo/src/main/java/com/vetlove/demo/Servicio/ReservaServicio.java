package com.vetlove.demo.Servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Fecha;
import com.vetlove.demo.Entidad.Reserva;
import com.vetlove.demo.EntidadRequest.AddReservaRequest;
import com.vetlove.demo.Interfaz.IReservaServicio;
import com.vetlove.demo.Repositorio.FechaRepositorio;
import com.vetlove.demo.Repositorio.ReservaRepositorio;

@Service
public class ReservaServicio implements IReservaServicio{
    
    @Autowired
    private ReservaRepositorio repoReserva;

    @Autowired
    private FechaRepositorio repoFecha;

    @Override
    public List<Reserva> getReservasDisponibles() {
        return repoReserva.findByDisponible(true);
    }

    @Override
    public List<Reserva> getReservasNoDisponibles() {
        return repoReserva.findByDisponible(false);
    }

    @Override
    public List<Reserva> getReservasDisponiblesXDia(String fecha) {
        Fecha date = repoFecha.findByFecha(fecha);
        List<Reserva> lista = repoReserva.findByFecha(date);
        List<Reserva> retornar = new ArrayList<Reserva>();
        for (Reserva reserva : lista) {
            if (reserva.getDisponible()) {
                retornar.add(reserva);
            }
        }
        return retornar;
    }

    @Override
    public List<Reserva> getReservasNoDisponiblesXDia(String fecha) {
        Fecha date = repoFecha.findByFecha(fecha);
        List<Reserva> lista = repoReserva.findByFecha(date);
        List<Reserva> retornar = new ArrayList<Reserva>();
        for (Reserva reserva : lista) {
            if (!reserva.getDisponible()) {
                retornar.add(reserva);
            }
        }
        return retornar;
    }

    @Override
    public int reservar(AddReservaRequest request) {
        List<Reserva> reservas = repoReserva.findByFecha(repoFecha.findByFecha(request.getFecha()));
        for (Reserva reserva : reservas) {
            if (reserva.getHora().getHorario().equals(request.getHorario())) {
                if (reserva.getDisponible()) {
                    reserva.setDisponible(false);
                    repoReserva.save(reserva);
                    return 1; //Se guarda la reserva correctamente
                }
                else {
                    return -1; //La fecha no está disponible
                }
            }
        }
        return -2; //Error en el sistema
    }


}
