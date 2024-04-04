package com.vetlove.demo.Interfaz;

import java.util.Collection;

import com.vetlove.demo.Entidad.Veterinario;

public interface IVeterinarioServicio {
    public Veterinario SearchById(Long id);
    public Collection<Veterinario> SearchAll();
    public void deleteVeterinario(Long id);
    public void save(Veterinario veterinario);
    public void updateVeterinario(Veterinario veterinario);
    public Long validateLogin(String cedula, String password);
}
