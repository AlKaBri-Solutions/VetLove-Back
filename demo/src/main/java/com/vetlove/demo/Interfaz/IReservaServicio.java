package com.vetlove.demo.Interfaz;

import java.util.List;

import com.vetlove.demo.Entidad.Reserva;
import com.vetlove.demo.EntidadRequest.AddReservaRequest;

public interface IReservaServicio {
    public List<Reserva> getReservasDisponibles();
    public List<Reserva> getReservasNoDisponibles();
    public List<Reserva> getReservasDisponiblesXDia(String fecha);
    public List<Reserva> getReservasNoDisponiblesXDia(String fecha);
    public int reservar(AddReservaRequest request);
}