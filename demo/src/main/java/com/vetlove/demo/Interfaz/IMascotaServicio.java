package com.vetlove.demo.Interfaz;

import java.util.List;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;

public interface IMascotaServicio {
    public Mascota SearchById(Long id);
    public List<Mascota> SearchAll();
    public List<Mascota> SearchAllByDueno(Cliente dueno);
    public List<Mascota> SearchAllByVeterinarioId(Long id);
    public void save(Mascota mascota);
    public void deleteMascota(Long id);
    public void updateMascota(Mascota mascota);
    public void undeleteMascota(Long id);
    public int countAll();
    public int countActivas();
}