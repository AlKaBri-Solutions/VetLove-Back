package com.vetlove.demo.Interfaz;

import java.util.List;

import com.vetlove.demo.Entidad.Medicamento;
import com.vetlove.demo.Entidad.Tratamiento;

public interface IMedicamentoServicio {
    public int aplicarMedicamento(Tratamiento tratamiento);
    public int cambiarMedicamento(Tratamiento tratamiento);
    public Medicamento getMedicamentoByNombre(String nombre);
    public List<Medicamento> getMedicamentosSimilares(Medicamento medicamento);
    public List<Medicamento> SearchAll();
    public double findVentasTotales();
    public double findGananciasTotales();
    public List<Medicamento> findTopVendidos();
}
