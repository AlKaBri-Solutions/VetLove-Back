package com.vetlove.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;






@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200") /////////////////////////
public class TratamientoController {
    //Prueba
    @Autowired //Prueba
    private TratamientoRepositorio repoTratamiento; //Prueba
    //Prueba

    //Métodos GET
    //http://localhost:8090/mascota/all
    @GetMapping("/find")
    public Tratamiento getTratamientoById(@RequestParam Long id) {
        return repoTratamiento.findById(id).get();
    }

}