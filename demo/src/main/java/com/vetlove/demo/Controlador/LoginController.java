package com.vetlove.demo.Controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Interfaz.IVeterinarioServicio;

import io.swagger.v3.oas.annotations.parameters.RequestBody;






@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200") /////////////////////////
public class LoginController {
    @Autowired
    private IVeterinarioServicio veterinarioServicio;

    //Métodos GET
    
    
    
    //Métodos POST
    @PostMapping("vetAuth")
    public int validateLoginVeterinario(@RequestBody String cedula, @RequestBody String password) {
        return Integer.parseInt(String.valueOf(veterinarioServicio.validateLogin(cedula, password)));
    }
    

    //Métodos PUT
    

    //Métodos DELETE
    
}