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

import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.EntidadConsulta.TratamientosXEnfermedadLMConsulta;
import com.vetlove.demo.EntidadRequest.AddTratamientoRequest;
import com.vetlove.demo.Interfaz.ITratamientoServicio;

@RestController
@RequestMapping("/tratamiento")
@CrossOrigin(origins = "http://localhost:4200") /////////////////////////
public class TratamientoController {
    @Autowired
    private ITratamientoServicio servicioTratamiento;

    //Métodos GET
    @GetMapping("/find")
    public Tratamiento getTratamientoById(@RequestParam Long id) {
        return servicioTratamiento.searchById(id);
    }

    @GetMapping("/findVeterinario")
    public List<Tratamiento> getTratamientoActivoByVeterinarioId(@RequestParam Long id) {
        return servicioTratamiento.SearchActivosByVeterinarioId(id);
    }
    

    @GetMapping("/findMascota")
    public List<Tratamiento> getTratamientoByMascotaId(@RequestParam Long id) {
        return servicioTratamiento.SearchAllByMascotaId(id);
    }
    

    @GetMapping("/countActivos") //Tratamientos activos: tratamientos que no tengan medicamento aplicado
    public int countTratamientosActivos() {
        return servicioTratamiento.countTratamientosActivos();
    }
    
    @GetMapping("/countRealizados") //Tratamientos realizados: tratamientos que tengan medicamento aplicado
    public int countTratamientosRealizados() {
        return servicioTratamiento.countTratamientosRealizados();
    }

    @GetMapping("/all")
    public List<Tratamiento> getAllTratamientos() {
        return servicioTratamiento.SearchAll();
    }

    @GetMapping("/countTratamientosLastMonth")
    public int getCountTratamientosLastMonth() {
        return servicioTratamiento.getCountTratamientosLastMonth();
    }
    
    @GetMapping("/countTratameintosXEnfermedadLastMonth")
    public List<TratamientosXEnfermedadLMConsulta> getTratamientosXEnfermedadLMConsulta() {
        return servicioTratamiento.tratamientosXEnfermedadLastMonth();
    }
    
    //Métodos POST
    @PostMapping("/add")
    public int addTratamiento(@RequestBody AddTratamientoRequest tratamiento) {
        return servicioTratamiento.save(tratamiento);
    }
    

}