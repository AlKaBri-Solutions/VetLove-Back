package com.vetlove.demo.Interfaz;

import java.util.List;

import com.vetlove.demo.Entidad.Cliente;

public interface IClienteServicio {
    public Cliente SearchById(Long id);
    public List<Cliente> SearchAll();
    public Cliente SearchByCedula(String cedula);
    public Long validateLogin(String cedula);
    public void save(Cliente cliente);
    public void deleteCliente(Long id);
    public void updateCliente(Cliente cliente);
}