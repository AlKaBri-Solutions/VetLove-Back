package com.vetlove.demo.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vetlove.demo.Entidad.Medicamento;
import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.EntidadConsulta.TratamientosXEnfermedadLMConsulta;
import com.vetlove.demo.Interfaz.IMedicamentoServicio;









@RestController
@RequestMapping("/medicamento")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentoController {
    
    @Autowired
    private IMedicamentoServicio medicamentoServicio;

    //Métodos GET
    @GetMapping("/medicamentosSimilares")
    public List<Medicamento> getMedicamentosSimilares(@RequestBody Medicamento medicamento) {
        return medicamentoServicio.getMedicamentosSimilares(medicamento);
    }

    @GetMapping("/find/{nombre}")
    public Medicamento getMedicamentoByNombre(@PathVariable String nombre) {
        return medicamentoServicio.getMedicamentoByNombre(nombre);
    }

    @GetMapping("/all")
    public List<Medicamento> getAllVeterinarios() {
        return medicamentoServicio.SearchAll();
    }
    
    @GetMapping("/getVentasTotales")
    public double getVentasTotales() {
        return medicamentoServicio.findVentasTotales();
    }

    @GetMapping("getGananciasTotales")
    public double getGananciasTotales() {
        return medicamentoServicio.findGananciasTotales();
    }
    

    @GetMapping("/getTopVendidos")
    public List<Medicamento> getTopVendidos() {
        return medicamentoServicio.findTopVendidos();
    }
    
    @GetMapping("/countMedicamentoXEnfermedadLastMonth")
    public List<TratamientosXEnfermedadLMConsulta> findMedicamentoXEnfermedadLastMonth() {
        return medicamentoServicio.countMedicamentoXEnfermedadLastMonth();
    }
    

    //Métodos POST
    @PostMapping("/aplicarMedicamento")
    public int aplicarMedicamento(@RequestBody Tratamiento tratamiento) {
        return medicamentoServicio.aplicarMedicamento(tratamiento);
    }

    @PostMapping("/cambiarMedicamento")
    public int cambiarMedicamento(@RequestBody Tratamiento tratamiento) {
        return medicamentoServicio.cambiarMedicamento(tratamiento);
    }


    //Métodos PUT


    //Métodos DELETE
}
