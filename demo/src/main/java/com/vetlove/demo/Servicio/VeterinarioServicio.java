package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.Interfaz.IVeterinarioServicio;
import com.vetlove.demo.Repositorio.EstadoVetRepositorio;
import com.vetlove.demo.Repositorio.VeterinarioRepositorio;

@Service
public class VeterinarioServicio implements IVeterinarioServicio{
    @Autowired
    VeterinarioRepositorio repoVeterinario;

    @Autowired
    EstadoVetRepositorio repoEstadoVet;

    @Override
    public Veterinario SearchById(Long id){
        return repoVeterinario.findById(id).get();
    }

    @Override
    public List<Veterinario> SearchAll(){
        return repoVeterinario.findAll();
    }

    @Override
    public void deleteVeterinario(Long id){
        Veterinario veterinario = repoVeterinario.findById(id).orElse(null);
        veterinario.setEstado(repoEstadoVet.findByNombre("Inactivo"));
        repoVeterinario.save(veterinario);
    }

    @Override
    public Veterinario save(Veterinario veterinario){
        return repoVeterinario.save(veterinario);
    }

    @Override
    public void updateVeterinario(Veterinario veterinario) {
        repoVeterinario.save(veterinario);
    }

    @Override
    public Long validateLogin(String cedula, String password){
        for (Veterinario veterinario : repoVeterinario.findAll()) {
            if (cedula.equals(veterinario.getCedula())) {
                if (password.equals(veterinario.getContrasenia()))
                    return veterinario.getIdVeterinario();
            }
        }
        return (long) -1;
    }

    @Override
    public Veterinario SearchByCedula(String cedula) {
        return repoVeterinario.findByCedula(cedula);
    }

    @Override
    public void undeleteVeterinario(Long id) {
        Veterinario veterinario = repoVeterinario.findById(id).orElse(null);
        veterinario.setEstado(repoEstadoVet.findByNombre("Activo"));
        repoVeterinario.save(veterinario);
    }

	@Override
	public int findCountVeterinariosActivos() {
		return repoVeterinario.findCountVeterinariosActivos();
	}

    @Override
	public int findCountVeterinariosInactivos() {
		return repoVeterinario.findCountVeterinariosInactivos();
	}
}