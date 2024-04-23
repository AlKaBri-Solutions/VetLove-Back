package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.EstadoVet;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Interfaz.IEspecialidadServicio;
import com.vetlove.demo.Interfaz.IEstadoMasServicio;
import com.vetlove.demo.Interfaz.IEstadoVetServicio;
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

    @Autowired
    IEstadoVetServicio estadoVetServicio;
    
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

    @GetMapping("/countAll")
    public int countAll() {
        return veterinarioServicio.SearchAll().size();
    }
    
    //Métodos POST
    @PostMapping("/add")
    public void addVeterinario(@RequestBody Veterinario vet) {
        EstadoVet estado = estadoVetServicio.SearchByName("Activo");
        vet.setEstado(estado);
        veterinarioServicio.save(vet);
    }
    


    //Métodos PUT
    @PutMapping("/update")
    public void updateMascota(@RequestBody Veterinario veterinario) {
        veterinarioServicio.updateVeterinario(veterinario);
    }


    //Métodos DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteVeterinarioById(@PathVariable Long id) {
        veterinarioServicio.deleteVeterinario(id);
    }

    @DeleteMapping("/undelete/{id}")
    public void undeleteVeterinarioById(@PathVariable Long id) {
        veterinarioServicio.undeleteVeterinario(id);
    }

}