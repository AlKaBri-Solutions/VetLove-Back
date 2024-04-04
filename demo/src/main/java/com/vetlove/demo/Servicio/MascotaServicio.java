package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Interfaz.IMascotaServicio;
import com.vetlove.demo.Repositorio.MascotaRepositorio;

@Service
public class MascotaServicio implements IMascotaServicio{
    @Autowired
    MascotaRepositorio repoMascota;

    @SuppressWarnings("null")
    @Override
    public Mascota SearchById(Long id){
        return repoMascota.findById(id).get();
    }

    @Override
    public List<Mascota> SearchAll(){
        return repoMascota.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public void deleteMascota(Long id){
        repoMascota.deleteById(id);
    }

    @SuppressWarnings("null")
    @Override
    public void save(Mascota mascota){
        repoMascota.save(mascota);
    }

    @SuppressWarnings("null")
    @Override
    public void updateMascota(Mascota mascota) {
        repoMascota.save(mascota);
    }

    @Override
    public List<Mascota> SearchAllByDueno(Cliente dueno) {
        return repoMascota.findByDueno(dueno);
    }

}