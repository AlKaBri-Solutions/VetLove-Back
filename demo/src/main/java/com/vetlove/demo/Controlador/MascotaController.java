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

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.EntidadRequest.AddMascotaRequest;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Interfaz.IEstadoMasServicio;
import com.vetlove.demo.Interfaz.IMascotaServicio;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;






@RestController
@RequestMapping("/mascota")
@CrossOrigin(origins = "http://localhost:4200") /////////////////////////
public class MascotaController {
    @Autowired
    private IMascotaServicio mascotaServicio;

    @Autowired
    private IClienteServicio clienteServicio;

    @Autowired
    private IEstadoMasServicio estadoMasServicio;

    @Autowired
    private IVeterinarioServicio veterinarioServicio;

    //Métodos GET
    //http://localhost:8090/mascota/all
    @GetMapping("/all")
    public List<Mascota> getAllMascotas() {
        return mascotaServicio.SearchAll();
    }

    //http://localhost:8090/mascota/find?id=1
    @GetMapping("/find")
    public Mascota getMascotaById(@RequestParam Long id) {
        return mascotaServicio.SearchById(id);
    }

    @GetMapping("/client")
    public List<Mascota> getMascotasByClienteId(@RequestParam Long id) {
        return mascotaServicio.SearchAllByDueno(clienteServicio.SearchById(id));
    }

    @GetMapping("/veterinario")
    public List<Mascota> getMascotaByVeterinarioId(@RequestParam Long id) {
        return mascotaServicio.SearchAllByVeterinarioId(id);
    }
    
    @GetMapping("/countAll")
    public int countAll() {
        return mascotaServicio.countAll();
    }

    @GetMapping("/countActivas")
    public int countActivas() {
        return mascotaServicio.countActivas();
    }
    

    //Métodos POST
    @PostMapping("/add")
    public void addMascota(@RequestBody AddMascotaRequest params) {
        Cliente dueno = clienteServicio.SearchByCedula(params.getCedula());
        Mascota mascota = params.getMascota();
        mascota.setDueno(dueno);
        mascotaServicio.save(mascota);
    }
    

    //Métodos PUT
    @PutMapping("/update")
    public void updataeMascota(@RequestBody Mascota mascota) {
        Cliente dueno = mascotaServicio.SearchById(mascota.getId()).getDueno();
        mascota.setDueno(dueno);
        mascotaServicio.save(mascota);
    }
    
    //Métodos DELETE
    //http://localhost:8090/mascota/delete/1
    @DeleteMapping("/delete/{id}")
    public void deleteMascotaById(@PathVariable Long id) {
        mascotaServicio.deleteMascota(id);
    }

    @DeleteMapping("/undelete/{id}")
    public void undeleteMascotaById(@PathVariable Long id) {
        mascotaServicio.undeleteMascota(id);
    }
}