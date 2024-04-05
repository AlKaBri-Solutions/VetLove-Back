package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;
import com.vetlove.demo.Repositorio.VeterinarioRepositorio;

@Service
public class VeterinarioServicio implements IVeterinarioServicio{
    @Autowired
    VeterinarioRepositorio repoVeterinario;

    @SuppressWarnings("null")
    @Override
    public Veterinario SearchById(Long id){
        return repoVeterinario.findById(id).get();
    }

    @Override
    public List<Veterinario> SearchAll(){
        return repoVeterinario.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public void deleteVeterinario(Long id){
        repoVeterinario.deleteById(id);
    }

    @SuppressWarnings("null")
    @Override
    public void save(Veterinario veterinario){
        repoVeterinario.save(veterinario);
    }

    @SuppressWarnings("null")
    @Override
    public void updateVeterinario(Veterinario veterinario) {
        repoVeterinario.save(veterinario);
    }

    @Override
    public Long validateLogin(String cedula, String password) {
        for (Veterinario veterinario : repoVeterinario.findAll()) {
            if (cedula.equals(veterinario.getCedula())) {
                if (password.equals(veterinario.getContrasenia()))
                    return veterinario.getIdVeterinario();
            }
        }
        return (long) -1;
    }

}