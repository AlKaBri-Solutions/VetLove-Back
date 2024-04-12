package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Interfaz.IMascotaServicio;
import com.vetlove.demo.Repositorio.EstadoMasRepositorio;
import com.vetlove.demo.Repositorio.MascotaRepositorio;

@Service
public class MascotaServicio implements IMascotaServicio{
    @Autowired
    MascotaRepositorio repoMascota;

    @Autowired
    EstadoMasRepositorio repoEstadoMas;

    @Override
    public Mascota SearchById(Long id){
        return repoMascota.findById(id).get();
    }

    @Override
    public List<Mascota> SearchAll(){
        return repoMascota.findAll();
    }

    @Override
    public void deleteMascota(Long id){
        Mascota mascota = repoMascota.findById(id).orElse(null);
        mascota.setEstado(repoEstadoMas.findByNombre("De baja"));
        repoMascota.save(mascota);
    }
    
    @Override
    public void save(Mascota mascota){
        repoMascota.save(mascota);
    }

    @Override
    public void updateMascota(Mascota mascota) {
        repoMascota.save(mascota);
    }

    @Override
    public List<Mascota> SearchAllByDueno(Cliente dueno) {
        return repoMascota.findByDueno(dueno);
    }

    @Override
    public List<Mascota> SearchAllByVeterinarioId(Long id) {
        return repoMascota.findByVeterinarioId(id);
    }

    @Override
    public void undeleteMascota(Long id) {
        Mascota mascota = repoMascota.findById(id).orElse(null);
        mascota.setEstado(repoEstadoMas.findByNombre("Ingresado"));
        repoMascota.save(mascota);
    }

}