package com.vetlove.demo.Repositorio;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetlove.demo.Entidad.Medicamento;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MedicamentoRepositorioTest {

    @Autowired
    private MedicamentoRepositorio medicamentoRepositorio;

    @BeforeEach
    public void setUp(){
        medicamentoRepositorio.save(new Medicamento(120000f,100000f,5,10));
        medicamentoRepositorio.save(new Medicamento(280000f,180000f,4,2));
        medicamentoRepositorio.save(new Medicamento(50000f,100000f,1,5));
        medicamentoRepositorio.save(new Medicamento(560000f,5400000f,7,0));
        medicamentoRepositorio.save(new Medicamento(450000f,350000f,2,0));
    }

    //Pruebas para los queries de medicamento (3 Pruebas)
    @Test
    public void MedicamentoRepositorio_findVentasTotales_VentasTotales(){

        Double ventasTotales = medicamentoRepositorio.findVentasTotales();

        Assertions.assertThat(ventasTotales).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(ventasTotales).isEqualTo(1860000.0); 
    }

    @Test
    public void MedicamentoRepositorio_findGananciasTotales_GananciasTotales(){

        Double gananciasTotales = medicamentoRepositorio.findGananciasTotales();

        Assertions.assertThat(gananciasTotales).isEqualTo(-4580000.0);

    }

    @Test
    public void MedicamentoRepositorio_findTopVendidos_NotEmpyList(){

        List<Medicamento> medicamentos = medicamentoRepositorio.findTopVendidos();

        Assertions.assertThat(medicamentos).isNotNull();
        Assertions.assertThat(medicamentos.size()).isEqualTo(3);
        Assertions.assertThat(medicamentos.get(0).getVendidas()).isEqualTo(10);
        Assertions.assertThat(medicamentos.get(1).getVendidas()).isEqualTo(5);
        Assertions.assertThat(medicamentos.get(2).getVendidas()).isEqualTo(2);
    }
}
