package com.vetlove.demo.DTOs;

import lombok.Data;

@Data
public class VeterinarioDTO {
    Long idVeterinario;
    String cedula;
    String nombre;
    String fotoUrl; 
}
