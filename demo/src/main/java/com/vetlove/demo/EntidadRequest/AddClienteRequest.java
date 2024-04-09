package com.vetlove.demo.EntidadRequest;

import com.vetlove.demo.Entidad.Cliente;

public class AddClienteRequest {
    private Cliente cliente;
    private String id;
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
}
