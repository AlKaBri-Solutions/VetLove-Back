package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.EntidadRequest.AddClienteRequest;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;




@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200") /////////////////////////
public class ClienteController {
    @Autowired
    private IClienteServicio clienteServicio;

    @Autowired
    private IVeterinarioServicio veterinarioServicio;

    //Métodos GET


    //http://localhost:8090/cliente/all
    @GetMapping("/all")
     public List<Cliente> getClientes (){
        return clienteServicio.SearchAll(); 
     }

     //http://localhost:8090/cliente/veterinario?id=1
     @GetMapping("/veterinario")
    public List<Cliente> getClienteByVeterinarioId(@RequestParam Long id) {
        return clienteServicio.SearchAllByVeterinario(veterinarioServicio.SearchById(id));
    }
    
    //http://localhost:8090/cliente/find?id=1
    @GetMapping("find")
    public Cliente getClienteById(@RequestParam Long id) {
        return clienteServicio.SearchById(id);
    }


    //http://localhost:8090/cliente/findCedula?cedula=1125248041
    @GetMapping("/findCedula")
    public Cliente getClienteByCedula(@RequestParam String cedula) {
        return clienteServicio.SearchByCedula(cedula);
    }
    
    
    //Métodos POST
    //http://localhost:8090/cliente/add
    @PostMapping("/add")
    public void addCliente(@RequestBody AddClienteRequest params) {
        
        Cliente client = params.getCliente();
        Veterinario veterinario = veterinarioServicio.SearchById(Long.parseLong(params.getId()));
        client.setVeterinario(veterinario);
        clienteServicio.save(client);
    }
    
    //Métodos PUT
    //http://localhost:8090/cliente/update
    @PutMapping("/update")
    public void updataeCliente(@RequestBody AddClienteRequest params) {
        Veterinario veterinario = clienteServicio.SearchById(Long.parseLong(params.getId())).getVeterinario();
        Cliente cliente = params.getCliente();
        cliente.setVeterinario(veterinario);
        clienteServicio.save(cliente);
    }
    

    //Métodos DELETE
    
}