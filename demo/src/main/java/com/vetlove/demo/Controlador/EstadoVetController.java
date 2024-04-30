package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.EstadoVet;
import com.vetlove.demo.Interfaz.IEstadoVetServicio;

@RestController
@RequestMapping("/estadoVet")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadoVetController {
    @Autowired
    private IEstadoVetServicio estadoVetServicio;


    @GetMapping("/all")
    public List<EstadoVet> getAllEstadoVet() {
        return estadoVetServicio.SearchAll();
    }
}
