package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Interfaz.IEstadoMasServicio;
import com.vetlove.demo.Interfaz.IMascotaServicio;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;

@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "localhost:4200")
public class veterinarioController {

    @Autowired
    IClienteServicio clienteServicio;

    @Autowired
    IMascotaServicio mascotaServicio;

    @Autowired
    IVeterinarioServicio veterinarioServicio;

    @Autowired
    IEstadoMasServicio estadoMasServicio;
    
    @GetMapping("/mascotas")
    public List<Mascota> mostrarTodasMascotas() {
        return mascotaServicio.SearchAll();
    }
    
    


}