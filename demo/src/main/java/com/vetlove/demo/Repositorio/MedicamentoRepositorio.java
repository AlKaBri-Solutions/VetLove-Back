package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Enfermedad;
import com.vetlove.demo.Entidad.Medicamento;

@Repository
public interface MedicamentoRepositorio extends JpaRepository<Medicamento, Long>{
    public Medicamento findByNombre(String nombre);
    public List<Medicamento> findByEnfermedad(Enfermedad enfermedad);

    @Query(value="SELECT SUM(COSTO * VENDIDAS)\r\n" + //
    "FROM MEDICAMENTO\r\n",
    nativeQuery = true)
    public double findGananciasTotales();

    @Query(value="SELECT TOP 3 *\r\n" + //
        "FROM MEDICAMENTO\r\n" + //
        "ORDER BY VENDIDAS DESC\r\n"
    , nativeQuery = true)
    public List<Medicamento> findTopVendidos();
}