package com.vetlove.demo.Interfaz;

import java.util.Collection;
import java.util.List;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;

public interface IMascotaServicio {
    public Mascota SearchById(Long id);
    public List<Mascota> SearchAll();
    public Collection<Mascota> SearchAllByDueno(Cliente dueno);
    public void save(Mascota mascota);
    public void deleteMascota(Long id);
    public void updateMascota(Mascota mascota);
}