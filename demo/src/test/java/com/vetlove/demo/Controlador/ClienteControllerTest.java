package com.vetlove.demo.Controlador;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Interfaz.IClienteServicio;

@WebMvcTest(controllers = ClienteController.class)
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ClienteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IClienteServicio clienteServicio;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void ClienteController_getClientes_ListClientes() throws Exception{

        when(clienteServicio.SearchAll()).thenReturn(List.of(
            new Cliente("1232434543", "Prueba5", "prueba1@gmail.com", "3022255997"),
            new Cliente("1324232453", "Prueba6", "prueba2@gmail.com", "3556669989"),
            new Cliente("1542353454", "Prueba7", "prueba3@gmail.com", "3122266995")
        ));

        ResultActions response = mockMvc.perform(
            get("/cliente/all")
        );

        response.andExpect(status().isOk())
        .andExpect(jsonPath("$.size()").value(3));
    }

    @Test
    public void ClienteController_getClienteByVeterinarioId_Cliente() throws Exception{

        when(clienteServicio.SearchById(1L)).thenReturn(
            new Cliente("1232434543", "Prueba5", "prueba1@gmail.com", "3022255997")
        );

        ResultActions response = mockMvc.perform(
            get("/cliente/veterinario?id=1")
        );

        response.andExpect(status().isOk())
        .andExpect(jsonPath("$.cedula").value("1232434543"))
        .andExpect(jsonPath("$.nombre").value("Prueba5"))
        .andExpect(jsonPath("$.correo").value("prueba1@gmail.com"))
        .andExpect(jsonPath("$.celular").value("3022255997"));
    }

    
}
