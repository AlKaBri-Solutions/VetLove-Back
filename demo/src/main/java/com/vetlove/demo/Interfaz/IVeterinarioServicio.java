package com.vetlove.demo.Interfaz;

import java.util.List;

import com.vetlove.demo.Entidad.Veterinario;

public interface IVeterinarioServicio {
    public Veterinario SearchById(Long id);
    public List<Veterinario> SearchAll();
    public void deleteVeterinario(Long id);
    public Veterinario save(Veterinario veterinario);
    public void updateVeterinario(Veterinario veterinario);
    public Long validateLogin(String cedula, String password);
    public Veterinario SearchByCedula(String cedula);
    public void undeleteVeterinario(Long id);
    public int findCountVeterinariosActivos();
    public int findCountVeterinariosInactivos();
}
