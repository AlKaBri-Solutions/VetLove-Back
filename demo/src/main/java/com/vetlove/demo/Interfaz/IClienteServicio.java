package com.vetlove.demo.Interfaz;

import java.util.List;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Veterinario;

public interface IClienteServicio {
    public Cliente SearchById(Long id);
    public List<Cliente> SearchAll();
    public List<Cliente> SearchAllByVeterinario(Veterinario veterinario);
    public Cliente SearchByCedula(String cedula);
    public Long validateLogin(String cedula);
    public Cliente save(Cliente cliente);
    public void deleteCliente(Long id);
    public Cliente updateCliente(Cliente cliente);
}