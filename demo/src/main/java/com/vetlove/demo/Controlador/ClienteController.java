package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200") /////////////////////////
public class ClienteController {
    @Autowired
    private IClienteServicio clienteServicio;

    @Autowired
    private IVeterinarioServicio veterinarioServicio;

    //Métodos GET
    @GetMapping("/veterinario")
    public List<Cliente> getClienteByVeterinarioId(@RequestParam Long id) {
        return clienteServicio.SearchAllByVeterinario(veterinarioServicio.SearchById(id));
    }
    
    @GetMapping("find")
    public Cliente getClienteById(@RequestParam Long id) {
        return clienteServicio.SearchById(id);
    }

    @GetMapping("/findCedula")
    public Cliente getClienteByCedula(@RequestParam String cedula) {
        return clienteServicio.SearchByCedula(cedula);
    }
    
    
    //Métodos POST
    @PostMapping("/add")
    public void addCliente(@RequestBody Cliente cliente) {
        clienteServicio.save(cliente);
    }
    
    //Métodos PUT
    @PutMapping("/update")
    public void updataeCliente(@RequestBody Cliente cliente) {
        Veterinario veterinario = clienteServicio.SearchById(cliente.getId()).getVeterinario();
        cliente.setVeterinario(veterinario);
        clienteServicio.save(cliente);
    }
    

    //Métodos DELETE
    
}