package com.vetlove.demo.Servicio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import com.vetlove.demo.Entidad.Administrador;
import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Enfermedad;
import com.vetlove.demo.Entidad.Especialidad;
import com.vetlove.demo.Entidad.EstadoMas;
import com.vetlove.demo.Entidad.EstadoVet;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Medicamento;
import com.vetlove.demo.Entidad.Prioridad;
import com.vetlove.demo.Entidad.Tratamiento;
import com.vetlove.demo.Entidad.Veterinario;
import com.vetlove.demo.EntidadConsulta.TratamientosXEnfermedadLMConsulta;
import com.vetlove.demo.EntidadRequest.AddTratamientoRequest;
import com.vetlove.demo.Interfaz.ITratamientoServicio;
import com.vetlove.demo.Repositorio.AdministradorRepositorio;
import com.vetlove.demo.Repositorio.ClienteRepositorio;
import com.vetlove.demo.Repositorio.EnfermedadRepositorio;
import com.vetlove.demo.Repositorio.EspecialidadRepositorio;
import com.vetlove.demo.Repositorio.EstadoMasRepositorio;
import com.vetlove.demo.Repositorio.EstadoVetRepositorio;
import com.vetlove.demo.Repositorio.MascotaRepositorio;
import com.vetlove.demo.Repositorio.MedicamentoRepositorio;
import com.vetlove.demo.Repositorio.PrioridadRepositorio;
import com.vetlove.demo.Repositorio.TratamientoRepositorio;
import com.vetlove.demo.Repositorio.VeterinarioRepositorio;

//Ejecutar una instancia de la aplicacion
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("test")
public class TratamientoServicioTestNaive {

    @Autowired
    private ITratamientoServicio servicioTratamiento;

    @Autowired
    ClienteRepositorio repoCliente;

    @Autowired
    MascotaRepositorio repoMascota;

    @Autowired
    VeterinarioRepositorio repoVeterinario;

    @Autowired
    EstadoMasRepositorio repoEstadoMas;

    @Autowired
    MedicamentoRepositorio repoMedicamento;

    @Autowired
    PrioridadRepositorio repoPrioridad;

    @Autowired
    EnfermedadRepositorio repoEnfermedad;

    @Autowired
    TratamientoRepositorio repoTratamiento;

    @Autowired
    EspecialidadRepositorio repoEspecialidad;

    @Autowired
    EstadoVetRepositorio repoEstadoVet;

    @Autowired
    AdministradorRepositorio repoAdministrador;

    @BeforeEach
    public void init() throws FileNotFoundException, IOException {
        repoMascota.save(new Mascota("Iris", "Husky", 3, 20000,
                                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));
                repoMascota.save(new Mascota("Max", "Samoyero", 5, 40000,
                                "https://images.hola.com/imagenes/mascotas/20200811173399/-de-perro-grandes-samoyedo/0-854-717/samoyedo-m.jpg?tx=w_680"));
                repoMascota.save(new Mascota("Yogui", "Golden", 4, 30000,
                                "https://www.hepper.com/wp-content/uploads/2021/11/golden-retriever_Shutterstock.jpg"));
                repoMascota.save(new Mascota("Max", "Labrador", 5, 2500,
                                "https://www.webconsultas.com/sites/default/files/styles/wch_image_schema/public/temas/caracteristicas-perro-labrador.jpg"));
        repoCliente.save(new Cliente("1125248041", "Alejandro Barragán", "alejo190404@gmail.com", "3017202327"));
        repoCliente.save(new Cliente("1001572832", "Laura Karara", "karara02@gmail.com", "3022678421"));

        repoVeterinario.save(new Veterinario("12345678", "Sebastián Angarita", "password",
                "https://images.ctfassets.net/pdf29us7flmy/69sCM6f2F5THBeBnNewynl/8ed3116aaf346a441d214b9f92748e21/-IND-001-036-_Types_of_Veterinary_Careers_Final.png?w=720&q=100&fm=jpg"));

        repoEspecialidad.save(new Especialidad("General"));

        repoEstadoVet.save(new EstadoVet("Activo"));

        Veterinario asociarVet = repoVeterinario.findById(1L).get();
        asociarVet.setEspecialidad(repoEspecialidad.findById(1L).get());
        asociarVet.setEstado(repoEstadoVet.findByNombre("Activo"));
        repoVeterinario.save(asociarVet);

        repoEstadoMas.save(new EstadoMas("Ingresado"));
        repoEstadoMas.save(new EstadoMas("De baja"));

        Mascota asociar = repoMascota.findById(1L).get();
        asociar.setDueno(repoCliente.findById(1L).get());
        asociar.setEstado(repoEstadoMas.findById(2L).get());
        repoMascota.save(asociar);

        asociar = repoMascota.findById(2L).get();
        asociar.setDueno(repoCliente.findById(1L).get());
        asociar.setEstado(repoEstadoMas.findById(2L).get());
        repoMascota.save(asociar);

        asociar = repoMascota.findById(3L).get();
        asociar.setDueno(repoCliente.findById(2L).get());
        asociar.setEstado(repoEstadoMas.findById(2L).get());
        repoMascota.save(asociar);

        asociar = repoMascota.findById(4L).get();
        asociar.setDueno(repoCliente.findById(2L).get());
        asociar.setEstado(repoEstadoMas.findById(2L).get());
        repoMascota.save(asociar);

        for (Long i = 1L; i <= 2L; i++) {
            Cliente asociarCliente = repoCliente.findById(i).orElse(null);

            if (asociarCliente != null) {
                asociarCliente.setVeterinario(repoVeterinario.findById(1L).orElse(null));

                repoCliente.save(asociarCliente);
            }
        }

        Prioridad prioridad1 = new Prioridad("Baja");
        Prioridad prioridad2 = new Prioridad("Media");
        Prioridad prioridad3 = new Prioridad("Alta");

        repoPrioridad.save(prioridad1);
        repoPrioridad.save(prioridad2);
        repoPrioridad.save(prioridad3);

        Enfermedad enfermedad = new Enfermedad("Parásitos");
        enfermedad.setPrioridad(repoPrioridad.findById(1L).orElse(null));
        repoEnfermedad.save(enfermedad);
        Enfermedad enfermedad1 = new Enfermedad("Diarrea");
        enfermedad1.setPrioridad(repoPrioridad.findById(2L).orElse(null));
        repoEnfermedad.save(enfermedad1);
        Enfermedad enfermedad2 = new Enfermedad("Asma");
        enfermedad2.setPrioridad(repoPrioridad.findById(3L).orElse(null));
        repoEnfermedad.save(enfermedad2);
        Enfermedad enfermedad3 = new Enfermedad("Dermatitis");
        enfermedad3.setPrioridad(repoPrioridad.findById(1L).orElse(null));
        repoEnfermedad.save(enfermedad3);
        Enfermedad enfermedad4 = new Enfermedad("Insuficiencia renal");
        enfermedad4.setPrioridad(repoPrioridad.findById(2L).orElse(null));
        repoEnfermedad.save(enfermedad4);
        Enfermedad enfermedad5 = new Enfermedad("Hipertensión");
        enfermedad5.setPrioridad(repoPrioridad.findById(3L).orElse(null));
        repoEnfermedad.save(enfermedad5);
        Enfermedad enfermedad6 = new Enfermedad("Epilepsia");
        enfermedad6.setPrioridad(repoPrioridad.findById(1L).orElse(null));
        repoEnfermedad.save(enfermedad6);
        Enfermedad enfermedad7 = new Enfermedad("Gingivitis");
        enfermedad7.setPrioridad(repoPrioridad.findById(2L).orElse(null));
        repoEnfermedad.save(enfermedad7);
        Enfermedad enfermedad8 = new Enfermedad("Epilepsia");
        enfermedad8.setPrioridad(repoPrioridad.findById(3L).orElse(null));
        repoEnfermedad.save(enfermedad8);
        Enfermedad enfermedad9 = new Enfermedad("Sarro");
        enfermedad9.setPrioridad(repoPrioridad.findById(1L).orElse(null));
        repoEnfermedad.save(enfermedad9);
        Enfermedad enfermedad10 = new Enfermedad("Vómito");
        enfermedad10.setPrioridad(repoPrioridad.findById(2L).orElse(null));
        repoEnfermedad.save(enfermedad10);

        Medicamento medicamento1 = new Medicamento(50, 25, 100, 0);
        medicamento1.setNombre("Alkagd");
        medicamento1.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento1);
        Medicamento medicamento2 = new Medicamento(50, 25, 100, 0);
        medicamento2.setNombre("Blkauhhgsd");
        medicamento2.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento2);
        Medicamento medicamento3 = new Medicamento(50, 25, 100, 0);
        medicamento3.setNombre("Cshgdfk");
        medicamento3.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento3);
        Medicamento medicamento4 = new Medicamento(50, 25, 100, 0);
        medicamento4.setNombre("Diigewkjlb");
        medicamento4.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento4);
        Medicamento medicamento5 = new Medicamento(50, 25, 100, 0);
        medicamento5.setNombre("Ehgsdhfi");
        medicamento5.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento5);
        Medicamento medicamento6 = new Medicamento(50, 25, 100, 0);
        medicamento6.setNombre("Fluisbgfd");
        medicamento6.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento6);
        Medicamento medicamento7 = new Medicamento(50, 25, 100, 0);
        medicamento7.setNombre("Guoishfdg");
        medicamento7.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento7);
        Medicamento medicamento8 = new Medicamento(50, 25, 100, 0);
        medicamento8.setNombre("Hiogsdfj");
        medicamento8.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento8);
        Medicamento medicamento9 = new Medicamento(50, 25, 100, 0);
        medicamento9.setNombre("Ioibdszfhdsbk");
        medicamento9.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento9);
        Medicamento medicamento10 = new Medicamento(50, 25, 100, 0);
        medicamento10.setNombre("Alkagd");
        medicamento1.setEnfermedad(enfermedad1);
        repoMedicamento.save(medicamento10);
        

        for (int i = 0; i < 4; i++) {
                        LocalDate startDate = LocalDate.of(2024, 5, 1);
                        
                        LocalDate endDate = LocalDate.of(2024, 5, 30);

                        Date dateInicio = new java.sql.Date(
                                        startDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
                        Date dateFinal = new java.sql.Date(
                            endDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());

                        Tratamiento tratamiento = new Tratamiento();
                        tratamiento.setFechaInicio(dateInicio);
                        tratamiento.setFechaFin(dateFinal);
                        Mascota mascota = repoMascota.findById((long) i + 1).get();
                        mascota.setEstado(repoEstadoMas.findByNombre("Ingresado"));
                        tratamiento.setMascota(mascota);
                        Long medicamentoId = (long) i + 1;
                        Medicamento medicamento = repoMedicamento.findById(medicamentoId).get();
                        tratamiento.setMedicamento(medicamento);
                        tratamiento.setCosto((float) medicamento.getPrecio());
                        if (i%2==0) {
                                tratamiento.setMedicamentoAplicado(false);
                        }
                        else {
                                tratamiento.setMedicamentoAplicado(true);
                                mascota.setEstado(repoEstadoMas.findByNombre("De baja"));
                                tratamiento.setMascota(mascota);
                                repoMascota.save(mascota);
                        }
                        repoTratamiento.save(tratamiento);
                }

                Administrador admin = new Administrador("1000586123", "super-secret-password");
                repoAdministrador.save(admin);

    }

    @Test
    public void TratamientoServicio_searchById_Tratamiento(){
        //Arrange
        repoTratamiento.save(new Tratamiento(
            new Date(2L),
            new Date(7L),
            5,
            false
        ));

        //Act
        Tratamiento tratamiento = servicioTratamiento.searchById(1L);

        //Assert
        Assertions.assertThat(tratamiento).isNotNull();

    }

    @Test
    public void TratamientoServicio_countTratamientosActivos_int(){
        //Arrange

        //Act

        int count = servicioTratamiento.countTratamientosActivos();

        //Assert

        Assertions.assertThat(count).isNotEqualTo(0);
        Assertions.assertThat(count).isEqualTo(2);
    }

    @Test
    public void TratamientoServicio_countTratamientosRealizados_int(){
        //Arrange

        //Act

        int count = servicioTratamiento.countTratamientosRealizados();

        //Assert

        Assertions.assertThat(count).isNotEqualTo(0);
        Assertions.assertThat(count).isEqualTo(2);
    }

    @Test
    public void TratamientoServicio_SearchAll_ListTratamiento(){
        //Arrange

        //Act
        List<Tratamiento> list = servicioTratamiento.SearchAll();

        //Assert
        Assertions.assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void TratamientoServicio_getCountTratamientosLastMonth_int(){
        //Arrange

        //Act
        int count = servicioTratamiento.getCountTratamientosLastMonth();

        //Assert
        Assertions.assertThat(count).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(count).isEqualTo(2);
    }

    @Test
    public void TratamientoServicio_tratamientosXEnfermedadLastMonth_ListTratamientosXEnfermedadLMConsulta(){
        //Arrange

        //Act
        List<TratamientosXEnfermedadLMConsulta> list = servicioTratamiento.tratamientosXEnfermedadLastMonth();

        //Assert
        Assertions.assertThat(list.size()).isEqualTo(4);
    }

    @Test
    public void TratamientoServicio_SearchAllByMascotaId_ListTratamiento(){
        //Arrange

        //Act
        List<Tratamiento> list = servicioTratamiento.SearchAllByMascotaId(1L);

        //Assert
        Assertions.assertThat(list.size()).isEqualTo(1);
    }

    @Test
    public void TratamientoServicio_SearchActivosByVeterinarioId_ListTratamiento(){
        //Arrange

        //Act
        List<Tratamiento> list = servicioTratamiento.SearchActivosByVeterinarioId(1L);

        //Assert
        Assertions.assertThat(list.size()).isEqualTo(2);
    }

    @Test
    public void TratamientoServicio_save_int1(){
        //Arrange
        Enfermedad enfermedad = repoEnfermedad.findById(2L).get();

        //Act
        AddTratamientoRequest request = new AddTratamientoRequest(
            enfermedad,
            "1125248041",
            "Iris",
            30
        );
        int id = servicioTratamiento.save(request);

        //Assert
        Assertions.assertThat(id).isEqualTo(1);
    }

    @Test
    public void TratamientoServicio_save_intNegative1(){
        //Arrange
        Enfermedad enfermedad = repoEnfermedad.findById(2L).get();

        //Act
        AddTratamientoRequest request = new AddTratamientoRequest(
            enfermedad,
            "1125248041",
            "Fernando",
            30
        );
        int id = servicioTratamiento.save(request);

        //Assert
        Assertions.assertThat(id).isEqualTo(-1);
    }

    @Test
    public void TratamientoServicio_save_intNegative2(){
        //Arrange
        Enfermedad enfermedad = repoEnfermedad.findById(2L).get();

        //Act
        AddTratamientoRequest request = new AddTratamientoRequest(
            enfermedad,
            "13248480874354",
            "Ginny",
            30
        );
        int id = servicioTratamiento.save(request);

        //Assert
        Assertions.assertThat(id).isEqualTo(-2);
    }

}