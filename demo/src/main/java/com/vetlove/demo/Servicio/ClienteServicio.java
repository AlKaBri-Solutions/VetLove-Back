package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Repositorio.ClienteRepositorio;

@Service
public class ClienteServicio implements IClienteServicio{

    @Autowired
    ClienteRepositorio repoCliente;

    @SuppressWarnings("null")
    @Override
    public Cliente SearchById(Long id) {
        return repoCliente.findById(id).get();
    }

    @Override
    public List<Cliente> SearchAll() {
        return repoCliente.findAll();
    }

    @Override
    public Long validateLogin(String user) {
        for (Cliente cliente : repoCliente.findAll()) {
            if (user.equals(cliente.getCedula())) {
                return cliente.getId();
            }
        }
        return (long) -1;
    }

    @SuppressWarnings("null")
    @Override
    public void save(Cliente cliente) {
        repoCliente.save(cliente);
    }
    
    @SuppressWarnings("null")
    @Override
    public void deleteCliente(Long id) {
        repoCliente.deleteById(id);
    }

    @SuppressWarnings("null")
    @Override
    public void updateCliente(Cliente cliente) {
        repoCliente.save(cliente);
    }

    @Override
    public Cliente SearchByCedula(String cedula) {
        return repoCliente.findByCedula(cedula);
    }

    @Override
    public List<Cliente> SearchAllByVeterinario(Veterinario veterinario) {
        return repoCliente.findByVeterinario(veterinario);
    }
}