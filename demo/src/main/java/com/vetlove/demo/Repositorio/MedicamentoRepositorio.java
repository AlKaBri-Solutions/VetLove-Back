package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Enfermedad;
import com.vetlove.demo.Entidad.Medicamento;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento, Long>{
    public Medicamento findByNombre(String nombre);
    public List<Medicamento> findByEnfermedad(Enfermedad enfermedad);
}