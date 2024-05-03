package com.vetlove.demo.Servicio;

import static org.mockito.Mockito.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Enfermedad;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Medicamento;
import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.EntidadConsulta.TratamientosXEnfermedadLMConsulta;
import com.vetlove.demo.EntidadRequest.AddTratamientoRequest;
import com.vetlove.demo.Repositorio.ClienteRepositorio;
import com.vetlove.demo.Repositorio.MascotaRepositorio;
import com.vetlove.demo.Repositorio.MedicamentoRepositorio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;
import com.vetlove.demo.Repositorio.TratamientosXEnfermedadLMConsultaRepositorio;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class TratamientoServicioTestMock {
    @Mock
    private TratamientoRepositorio repoTratamiento;

    @Mock
    private TratamientosXEnfermedadLMConsultaRepositorio repoConsulta;

    @Mock
    private MascotaRepositorio repoMascota;

    @Mock
    private MedicamentoRepositorio repoMedicamento;

    @Mock
    private ClienteRepositorio repoCliente;

    @InjectMocks
    private TratamientoServicio servicioTratamiento;

    @BeforeEach
    public void init(){
        
    }

    @Test
    public void TratamientoServicio_searchById_Tratamiento() {

        //Assert
        Tratamiento ts = new Tratamiento();
        ts.setCosto(5);
        ts.setFechaInicio(new Date(2L));
        ts.setFechaFin(new Date(5L));
        Optional<Tratamiento> t = Optional.ofNullable(new Tratamiento(
            new Date(2L),
            new Date(7L),
            5,
            false
        ));
        when(repoTratamiento.findById(1L)).thenReturn(t);

        //Act
        Tratamiento tratamiento = servicioTratamiento.searchById(1L);

        //Arrange
        Assertions.assertThat(tratamiento).isNotNull();

    }

    @Test
    public void TratamientoServicio_countTratamientosActivos_int(){

        //Assert
        List<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
        tratamientos.add(new Tratamiento(
            new Date(2L),
            new Date(7L),
            5,
            false
        ));
        tratamientos.add(new Tratamiento(
                new Date(3L),
                new Date(10L),
                10,
                true
            )
        );
        when(repoTratamiento.findAll()).thenReturn(tratamientos);

        //Act
        
        int count = servicioTratamiento.countTratamientosActivos();

        //Arrange

        Assertions.assertThat(count).isEqualTo(1);

    }

    @Test
    public void TratamientoServicio_countTratamientosRealizados_int(){

        //Assert
        List<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
        tratamientos.add(new Tratamiento(
            new Date(2L),
            new Date(7L),
            5,
            false
        ));
        tratamientos.add(new Tratamiento(
                new Date(3L),
                new Date(10L),
                10,
                true
            )
        );
        when(repoTratamiento.findAll()).thenReturn(tratamientos);

        //Act
        
        int count = servicioTratamiento.countTratamientosRealizados();

        //Arrange

        Assertions.assertThat(count).isEqualTo(1);

    }

    @Test
    public void TratamientoServicio_SearchAll_ListTratamiento(){

        //Assert
        List<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
        tratamientos.add(new Tratamiento(
            new Date(2L),
            new Date(7L),
            5,
            false
        ));
        tratamientos.add(new Tratamiento(
                new Date(3L),
                new Date(10L),
                10,
                true
            )
        );
        when(repoTratamiento.findAll()).thenReturn(tratamientos);
        

        //Act
        List<Tratamiento> list = servicioTratamiento.SearchAll();

        //Assert
        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(2);

    }

    @Test
    public void TratamientoServicio_getCountTratamientosLastMonth_int(){
        //Arrange
        when(repoTratamiento.findCountTratamientosLastMonth()).thenReturn(3);

        //Act
        int count = servicioTratamiento.getCountTratamientosLastMonth();

        //Assert
        Assertions.assertThat(count).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(count).isEqualTo(3);
    }

    @Test
    public void TratamientoServicio_tratamientosXEnfermedadLastMonth_ListTratamientosXEnfermedadLMConsulta(){
        //Arrange
        List<TratamientosXEnfermedadLMConsulta> tratamientos = new ArrayList<TratamientosXEnfermedadLMConsulta>();
        tratamientos.add(new TratamientosXEnfermedadLMConsulta(
            3,
            "Gingivitis"
        ));
        tratamientos.add(new TratamientosXEnfermedadLMConsulta(
            4,
            "Asma"
        ));
        when(repoConsulta.findTratameintosXEnfermedadLastMonth()).thenReturn(tratamientos);

        //Act
        List<TratamientosXEnfermedadLMConsulta> list = servicioTratamiento.tratamientosXEnfermedadLastMonth();

        //Assert
        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void TratamientoServicio_SearchAllByMascotaId_ListTratamiento(){
        //Arrange
        Optional<Mascota> mascota = Optional.ofNullable(new Mascota(
            "Ginny",
            "Persa",
            8,
            5000,
            "NO HAY"
        ));
        when(repoMascota.findById(1L)).thenReturn(mascota);
        //Arrange
        List<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
        Tratamiento tratamiento = new Tratamiento(
            new Date(2L),
            new Date(7L),
            5,
            false
        );
        tratamiento.setMascota(mascota.get());
        tratamientos.add(tratamiento);
        Tratamiento tratamiento2 = new Tratamiento(
            new Date(3L),
            new Date(10L),
            10,
            true
        );
        tratamiento2.setMascota(mascota.get());
        tratamientos.add(tratamiento2);
        when(repoTratamiento.findByMascota(mascota.get())).thenReturn(tratamientos);

        //Act
        List<Tratamiento> list = servicioTratamiento.SearchAllByMascotaId(1L);

        //Assert
        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void TratamientoServicio_SearchActivosByVeterinarioId_ListTratamiento(){
        //Arrange
        List<Tratamiento> tratamientos = new ArrayList<Tratamiento>();
        Tratamiento tratamiento = new Tratamiento(
            new Date(2L),
            new Date(7L),
            5,
            false
        );
        tratamientos.add(tratamiento);
        when(repoTratamiento.findByVeterinarioId(1L)).thenReturn(tratamientos);

        //Act
        List<Tratamiento> list = servicioTratamiento.SearchActivosByVeterinarioId(1L);

        //Assert
        Assertions.assertThat(list).isNotNull();
        Assertions.assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void TratamientoServicio_save_int1(){
        //Arrange
        Enfermedad enfermedad = new Enfermedad("Gonorrea");
        Medicamento medicamento = new Medicamento(12, 15, 200, 0);
        medicamento.setEnfermedad(enfermedad);
        List<Medicamento> medicamentos = new ArrayList<Medicamento>();
        medicamentos.add(medicamento);
        AddTratamientoRequest tratamiento = new AddTratamientoRequest(enfermedad, "1125248041", "Ginny", 30);
        when(repoMedicamento.findByEnfermedad(tratamiento.getEnfermedad())).thenReturn(medicamentos);

        List<Mascota> mascotas1 = new ArrayList<Mascota>();
        Mascota mascota = new Mascota("Ginny", "Persa", 8, 5000, "NO HAY");
        Mascota mascota2 = new Mascota("Dobby", "Criollo", 4, 6000, "TAMPOCO HAY");
        mascotas1.add(mascota);
        mascotas1.add(mascota2);

        Cliente dueno = new Cliente("1125248041", "Prueba5", "prueba1@gmail.com", "3022255997");
        dueno.setMascotas(mascotas1);

        List<Mascota> mascotas2 = new ArrayList<Mascota>();
        Mascota mascota3 = new Mascota("Dash", "Husky", 10, 35000, "NO HAY");
        mascotas2.add(mascota3);

        Cliente dueno2 = new Cliente("3454342321", "Prueba4", "prueba5@gmail.com", "3022255998");
        dueno2.setMascotas(mascotas2);

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(dueno);
        clientes.add(dueno2);

        when(repoCliente.findAll()).thenReturn(clientes);

        //Act
        int result = servicioTratamiento.save(tratamiento);

        //Assert
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    public void TratamientoServicio_save_intNegative1(){
        //Arrange
        Enfermedad enfermedad = new Enfermedad("Gonorrea");
        Medicamento medicamento = new Medicamento(12, 15, 200, 0);
        medicamento.setEnfermedad(enfermedad);
        List<Medicamento> medicamentos = new ArrayList<Medicamento>();
        medicamentos.add(medicamento);
        AddTratamientoRequest tratamiento = new AddTratamientoRequest(enfermedad, "1125248041", "Álvaro Uribe", 30);
        when(repoMedicamento.findByEnfermedad(tratamiento.getEnfermedad())).thenReturn(medicamentos);

        List<Mascota> mascotas1 = new ArrayList<Mascota>();
        Mascota mascota = new Mascota("Ginny", "Persa", 8, 5000, "NO HAY");
        Mascota mascota2 = new Mascota("Dobby", "Criollo", 4, 6000, "TAMPOCO HAY");
        mascotas1.add(mascota);
        mascotas1.add(mascota2);

        Cliente dueno = new Cliente("1125248041", "Prueba5", "prueba1@gmail.com", "3022255997");
        dueno.setMascotas(mascotas1);

        List<Mascota> mascotas2 = new ArrayList<Mascota>();
        Mascota mascota3 = new Mascota("Dash", "Husky", 10, 35000, "NO HAY");
        mascotas2.add(mascota3);

        Cliente dueno2 = new Cliente("3454342321", "Prueba4", "prueba5@gmail.com", "3022255998");
        dueno2.setMascotas(mascotas2);

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(dueno);
        clientes.add(dueno2);

        when(repoCliente.findAll()).thenReturn(clientes);

        //Act
        int result = servicioTratamiento.save(tratamiento);

        //Assert
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @Test
    public void TratamientoServicio_save_intNegative2(){
        //Arrange
        Enfermedad enfermedad = new Enfermedad("Gonorrea");
        Medicamento medicamento = new Medicamento(12, 15, 200, 0);
        medicamento.setEnfermedad(enfermedad);
        List<Medicamento> medicamentos = new ArrayList<Medicamento>();
        medicamentos.add(medicamento);
        AddTratamientoRequest tratamiento = new AddTratamientoRequest(enfermedad, "1597765189", "Ginny", 30);
        when(repoMedicamento.findByEnfermedad(tratamiento.getEnfermedad())).thenReturn(medicamentos);

        List<Mascota> mascotas1 = new ArrayList<Mascota>();
        Mascota mascota = new Mascota("Ginny", "Persa", 8, 5000, "NO HAY");
        Mascota mascota2 = new Mascota("Dobby", "Criollo", 4, 6000, "TAMPOCO HAY");
        mascotas1.add(mascota);
        mascotas1.add(mascota2);

        Cliente dueno = new Cliente("1125248041", "Prueba5", "prueba1@gmail.com", "3022255997");
        dueno.setMascotas(mascotas1);

        List<Mascota> mascotas2 = new ArrayList<Mascota>();
        Mascota mascota3 = new Mascota("Dash", "Husky", 10, 35000, "NO HAY");
        mascotas2.add(mascota3);

        Cliente dueno2 = new Cliente("3454342321", "Prueba4", "prueba5@gmail.com", "3022255998");
        dueno2.setMascotas(mascotas2);

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(dueno);
        clientes.add(dueno2);

        when(repoCliente.findAll()).thenReturn(clientes);

        //Act
        int result = servicioTratamiento.save(tratamiento);

        //Assert
        Assertions.assertThat(result).isEqualTo(-2);
    }
}
