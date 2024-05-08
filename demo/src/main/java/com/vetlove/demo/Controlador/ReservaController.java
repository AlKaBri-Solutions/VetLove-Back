package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Reserva;
import com.vetlove.demo.EntidadRequest.AddReservaRequest;
import com.vetlove.demo.Interfaz.IReservaServicio;



@RestController
@RequestMapping("/reserva")
@CrossOrigin(origins="localhost:4200")
public class ReservaController {
    @Autowired
    private IReservaServicio reservaServicio;

    @GetMapping("/disponibles")
    public List<Reserva> getReservasDisponibles(){
        return reservaServicio.getReservasDisponibles();
    }

    @GetMapping("/disponiblesXDia/{fecha}")
    public List<Reserva> getReservasDisponiblesXDia(@PathVariable String fecha){
        System.out.println("FECHA: " + fecha + "\n");
        return reservaServicio.getReservasDisponiblesXDia(fecha);
    }

    @GetMapping("/reservadas")
    public List<Reserva> getReservasNoDisponibles() {
        return reservaServicio.getReservasNoDisponibles();
    }

    @GetMapping("/reservadasXDia/{fecha}")
    public List<Reserva> getReservasNoDisponiblesXDia(@PathVariable String fecha) {
        System.out.println("FECHA: " + fecha + "\n");
        return reservaServicio.getReservasNoDisponiblesXDia(fecha);
    }

    @PostMapping("/reservar")
    public int reservar(@RequestBody AddReservaRequest request) {
        return reservaServicio.reservar(request);
    }
    
    
}
