package com.vetlove.demo.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Medicamento;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento, Long>{
    
}