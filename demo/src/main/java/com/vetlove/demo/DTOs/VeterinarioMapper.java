package com.vetlove.demo.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vetlove.demo.Entidad.Veterinario;

@Mapper
public interface VeterinarioMapper {
    VeterinarioMapper INSTANCE = Mappers.getMapper(VeterinarioMapper.class);

    VeterinarioDTO convert(Veterinario veterinario); 
}
