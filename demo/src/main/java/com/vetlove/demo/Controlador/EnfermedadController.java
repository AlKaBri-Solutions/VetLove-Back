package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Enfermedad;
import com.vetlove.demo.Interfaz.IEnfermedadServicio;


@RestController
@RequestMapping("/enfermedad")
@CrossOrigin(origins = "localhost:4200")
public class EnfermedadController {
    @Autowired
    private IEnfermedadServicio enfermedadServicio;

    @GetMapping("/all")
    public List<Enfermedad> getAllEnfermedades() {
        return enfermedadServicio.searchAll();
    }
    
}
