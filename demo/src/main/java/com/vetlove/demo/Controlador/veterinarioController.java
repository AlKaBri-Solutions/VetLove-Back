package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.EntidadRequest.AddVeterinarioRequest;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Interfaz.IEspecialidadServicio;
import com.vetlove.demo.Interfaz.IEstadoMasServicio;
import com.vetlove.demo.Interfaz.IMascotaServicio;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;


@RestController
@RequestMapping("/veterinario")
@CrossOrigin(origins = "http://localhost:4200")
public class veterinarioController {

    @Autowired
    IClienteServicio clienteServicio;

    @Autowired
    IMascotaServicio mascotaServicio;

    @Autowired
    IVeterinarioServicio veterinarioServicio;

    @Autowired
    IEstadoMasServicio estadoMasServicio;

    @Autowired
    IEspecialidadServicio especialidadServicio;
    
    //Métodos GET
    //localhost:8090/veterinario/all
    @GetMapping("/all")
    public List<Veterinario> getAllVeterinarios(){
        return veterinarioServicio.SearchAll();
    }

    //localhost:8090/veterinario/find?id=1
    @GetMapping("/find")
    public Veterinario getVeterinarioById(@RequestParam Long id){
        return veterinarioServicio.SearchById(id);
    }

    @GetMapping("/findCedula")
    public Veterinario getVeterinarioByCedula(@RequestParam String cedula) {
        return veterinarioServicio.SearchByCedula(cedula);
    }
    
    //Métodos POST
    @PostMapping("/add")
    public void addVeterinario(@RequestBody AddVeterinarioRequest request) {
        Veterinario vet = request.getVeterinario();
        vet.setEspecialidad(especialidadServicio.findByNombre(request.getEspecialidad()));
        veterinarioServicio.save(vet);
    }
    


    //Métodos PUT


    //Métodos DELETE


}