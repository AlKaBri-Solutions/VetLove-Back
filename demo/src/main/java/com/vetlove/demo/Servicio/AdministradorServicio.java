package com.vetlove.demo.Servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Administrador;
import com.vetlove.demo.Interfaz.IAdministradorServicio;
import com.vetlove.demo.Repositorio.AdministradorRepositorio;

@Service
public class AdministradorServicio implements IAdministradorServicio{

    @Autowired
    AdministradorRepositorio repoAdminsitrador;

    @Override
    public Administrador getAdministrador() {
        return repoAdminsitrador.findById(1L).orElse(null);
    }

    @Override
    public void updateAdministrador(Administrador admin) {
        Administrador administrador = repoAdminsitrador.findById(1L).orElse(null);
        administrador.setCedula(admin.getCedula());
        administrador.setContrasenia(admin.getContrasenia());
        repoAdminsitrador.save(administrador);
    }
    
}
