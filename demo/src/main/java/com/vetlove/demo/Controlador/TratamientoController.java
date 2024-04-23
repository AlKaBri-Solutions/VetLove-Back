package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.Interfaz.ITratamientoServicio;






@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200") /////////////////////////
public class TratamientoController {
    @Autowired
    private ITratamientoServicio servicioTratamiento;

    //Métodos GET
    //http://localhost:8090/tratamiento/all
    @GetMapping("/find")
    public Tratamiento getTratamientoById(@RequestParam Long id) {
        return servicioTratamiento.searchById(id);
    }

    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/all")
    public List<Tratamiento> getAllTratamientos(){
        return servicioTratamiento.SearchAll();
    }

}