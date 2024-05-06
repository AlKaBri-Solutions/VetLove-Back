package com.vetlove.demo.Servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.Interfaz.IClienteServicio;
import com.vetlove.demo.Repositorio.ClienteRepositorio;
import com.vetlove.demo.Repositorio.MascotaRepositorio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;

@Service
public class ClienteServicio implements IClienteServicio{

    @Autowired
    ClienteRepositorio repoCliente;

    @Autowired
    MascotaRepositorio repoMascota;

    @Autowired
    TratamientoRepositorio repoTratamiento;

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

    @Override
    public Cliente save(Cliente cliente) {
        return repoCliente.save(cliente);
    }
    

    @Override
    public void deleteCliente(Long id) {
        repoCliente.deleteById(id);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return repoCliente.save(cliente);
    }

    @Override
    public Cliente SearchByCedula(String cedula) {
        return repoCliente.findByCedula(cedula);
    }

    @Override
    public List<Cliente> SearchAllByVeterinario(Veterinario veterinario) {
        return repoCliente.findByVeterinario(veterinario);
    }

    @Override
    public void deleteById(Long id) {
        Cliente cliente = repoCliente.findById(id).get();
        for (Mascota mascota : cliente.getMascotas()) {
            for (Tratamiento t : repoTratamiento.findByMascota(mascota)) {
                repoTratamiento.deleteById(t.getIdTratamiento());
            }
            repoMascota.deleteById(mascota.getId());
        }
        repoCliente.deleteById(id);
    }
}