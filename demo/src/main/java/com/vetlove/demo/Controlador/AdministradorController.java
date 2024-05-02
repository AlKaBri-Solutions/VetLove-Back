package com.vetlove.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Administrador;
import com.vetlove.demo.Interfaz.IAdministradorServicio;



@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "localhost:4200")
public class AdministradorController {
    @Autowired
    private IAdministradorServicio administradorServicio;

    @GetMapping("/findAdmin")
    public Administrador getAdministrador() {
        return administradorServicio.getAdministrador();
    }
    
    @PutMapping("/update")
    public void updateAdministrador(@RequestBody Administrador admin) {
        administradorServicio.updateAdministrador(admin);
    }
}
