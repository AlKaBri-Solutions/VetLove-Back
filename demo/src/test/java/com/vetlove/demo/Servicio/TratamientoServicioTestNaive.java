package com.vetlove.demo.Servicio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Random;

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

        try (BufferedReader br = new BufferedReader(new FileReader(
                "./demo/src/main/resources/static/MEDICAMENTOS_VETERINARIA.csv"))) {
            String line = br.readLine();
            line = br.readLine();

            while ((line = br.readLine()) != null) {
                Medicamento medicamento = new Medicamento();
                String[] values = line.split(";");
                medicamento.setNombre(values[0]);
                medicamento.setPrecio(Float.parseFloat(values[1].substring(1)));
                medicamento.setCosto(Float.parseFloat(values[2].substring(1)));
                medicamento.setUnidades(Integer.parseInt(values[3]));
                medicamento.setVendidas(Integer.parseInt(values[4]));
                int randomNumber = (int) (Math.random() * 11);
                switch (randomNumber) {
                    case 0:
                        medicamento.setEnfermedad(enfermedad);
                        break;

                    case 1:
                        medicamento.setEnfermedad(enfermedad1);
                        break;

                    case 2:
                        medicamento.setEnfermedad(enfermedad2);
                        break;

                    case 3:
                        medicamento.setEnfermedad(enfermedad3);
                        break;

                    case 4:
                        medicamento.setEnfermedad(enfermedad4);
                        break;

                    case 5:
                        medicamento.setEnfermedad(enfermedad5);
                        break;

                    case 6:
                        medicamento.setEnfermedad(enfermedad6);
                        break;

                    case 7:
                        medicamento.setEnfermedad(enfermedad7);
                        break;

                    case 8:
                        medicamento.setEnfermedad(enfermedad8);
                        break;

                    case 9:
                        medicamento.setEnfermedad(enfermedad9);
                        break;

                    default:
                        medicamento.setEnfermedad(enfermedad10);
                        break;
                }

                repoMedicamento.save(medicamento);
            }
        }

        for (int i = 0; i < 4; i++) {
                        LocalDate startDate = LocalDate.of(2024, 1, 1);
                        
                        LocalDate endDate = LocalDate.of(2024, 6, 21);

                        long randomDays = new Random().nextLong(ChronoUnit.DAYS.between(startDate, endDate));

                        LocalDate randomDate = startDate.plusDays(randomDays);

                        long randomDays2 = new Random().nextLong(ChronoUnit.DAYS.between(randomDate, endDate));

                        LocalDate randomDate2 = randomDate.plusDays(randomDays2);

                        Date dateInicio = new java.sql.Date(
                                        randomDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
                        Date dateFinal = new java.sql.Date(
                                        randomDate2.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());

                        Tratamiento tratamiento = new Tratamiento();
                        tratamiento.setFechaInicio(dateInicio);
                        tratamiento.setFechaFin(dateFinal);
                        Mascota mascota = repoMascota.findById((long) i + 1).get();
                        mascota.setEstado(repoEstadoMas.findByNombre("Ingresado"));
                        tratamiento.setMascota(mascota);
                        Long medicamentoId = (long) i*3 + 1;
                        Medicamento medicamento = repoMedicamento.findById(medicamentoId).get();
                        tratamiento.setMedicamento(medicamento);
                        tratamiento.setCosto((float) medicamento.getPrecio());
                        if (Math.random() > 0.2) {
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
    }
}