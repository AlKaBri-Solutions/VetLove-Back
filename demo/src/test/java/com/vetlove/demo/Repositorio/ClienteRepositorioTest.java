package com.vetlove.demo.Repositorio;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetlove.demo.Entidad.Cliente;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ClienteRepositorioTest {

    @Autowired
    private ClienteRepositorio clienteRepositorio; 


    @BeforeEach
    public void setUp(){
        clienteRepositorio.save(new Cliente("1125248041", "Prueba 1", "prueba1@gmail.com", "3017202327"));
        clienteRepositorio.save(new Cliente("1001572832", "Prueba 2", "prueba2@gmail.com", "3022678421"));
        clienteRepositorio.save(new Cliente("1000000241", "Prueba 3", "prueba3@gmail.com", "3142211457"));
        clienteRepositorio.save(new Cliente("1000000123", "Prueba 4", "prueba4@gmail.com", "3003003030"));
    }

    //PRUEBAS CRUD
    //Create
    @Test
    public void ClienteRepositorio_AddCliente_CLiente(){
        Cliente clienteNuevo = new Cliente("1232434543", "Nuevo", "nuevo@gmail.com", "3014499885");

        clienteRepositorio.save(clienteNuevo);

        List<Cliente> clientes = clienteRepositorio.findAll(); 

        Assertions.assertThat(clientes).isNotNull();
        Assertions.assertThat(clientes.size()).isEqualTo(5);
        Assertions.assertThat(clienteRepositorio.findById(clienteNuevo.getId())).isNotEmpty();
        Assertions.assertThat(clienteNuevo.getCedula()).isEqualTo("1232434543"); 
        Assertions.assertThat(clienteNuevo.getNombre()).isEqualTo("Nuevo");
        Assertions.assertThat(clienteNuevo.getCorreo()).isEqualTo("nuevo@gmail.com");
        Assertions.assertThat(clienteNuevo.getCelular()).isEqualTo("3014499885");
    }

    //Read
    @Test
    public void ClienteRepositorio_FindAll_NotEmptyList(){
        Cliente cliente1 = new Cliente("1232434543", "Prueba5", "prueba1@gmail.com", "3022255997");
        Cliente cliente2 = new Cliente("1324232453", "Prueba6", "prueba2@gmail.com", "3556669989");
        Cliente cliente3 = new Cliente("1542353454", "Prueba7", "prueba3@gmail.com", "3122266995");
    
        clienteRepositorio.save(cliente1);
        clienteRepositorio.save(cliente2);
        clienteRepositorio.save(cliente3);

        List<Cliente> clientes = clienteRepositorio.findAll();

        Assertions.assertThat(clientes).isNotNull();
        Assertions.assertThat(clientes.size()).isEqualTo(7);
    }

    //Update
    @Test
    public void ClienteRepositorio_updateByCedula_Cliente(){
        String cedula = "1001572832";
        
        Cliente cliente = clienteRepositorio.findByCedula(cedula);
        cliente.setCedula("111111111");
        Cliente clienteUpdated = clienteRepositorio.save(cliente);

        Assertions.assertThat(clienteUpdated).isNotNull();
        Assertions.assertThat(clienteUpdated.getCedula()).isEqualTo("111111111"); 
    }

    //Delete
    // @Test
    // public void ClienteRepositorio_deleteById_EmptyCliente(){
    //     Long index = 3L; 

    //     clienteRepositorio.deleteById(index);

    //     Assertions.assertThat(clienteRepositorio.findById(index)).isEmpty();
    // }





}