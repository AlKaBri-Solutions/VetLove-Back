package com.vetlove.demo.DTOs;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.vetlove.demo.Entidad.Administrador;

@Mapper
public interface AdministradorMapper {
    AdministradorMapper INSTANCE = Mappers.getMapper(AdministradorMapper.class);

    AdministradorDTO covnert(Administrador administrador);
}
