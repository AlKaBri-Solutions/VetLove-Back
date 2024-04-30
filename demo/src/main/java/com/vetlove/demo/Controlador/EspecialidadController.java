package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Especialidad;
import com.vetlove.demo.Interfaz.IEspecialidadServicio;


@RestController
@RequestMapping("/especialidad")
@CrossOrigin(origins = "http://localhost:4200")
public class EspecialidadController {
    @Autowired
    private IEspecialidadServicio especialidadServicio;

    @GetMapping("/all")
    public List<Especialidad> getAllEsepecialidades() {
        return especialidadServicio.findAll();
    }
    
}
