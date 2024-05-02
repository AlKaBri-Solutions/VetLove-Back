package com.vetlove.demo.Repositorio;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.EstadoMas;
import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Veterinario;

@DataJpaTest
@RunWith(SpringRunner.class)
public class MascotaRepositorioTest {

    @Autowired
    private MascotaRepositorio mascotaRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private VeterinarioRepositorio veterinarioRepositorio;

    @Autowired
    private EstadoMasRepositorio estadoMasRepositorio;

    @BeforeEach
    public void setUp() {
        clienteRepositorio.save(new Cliente("1125248041", "Prueba 1", "prueba1@gmail.com", "3017202327"));
        clienteRepositorio.save(new Cliente("1001572832", "Prueba 2", "prueba2@gmail.com", "3022678421"));
    
        mascotaRepositorio.save(new Mascota("Mascota 1", "Husky", 3, 20000,
                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));
        mascotaRepositorio.save(new Mascota("Mascota 2", "Golden", 1, 35000,
                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));
        mascotaRepositorio.save(new Mascota("Mascota 2", "Samoyedo", 12, 40000,
                "https://t2.uc.ltmcdn.com/es/posts/4/6/5/como_saber_si_mi_husky_es_puro_50564_600.jpg"));

        veterinarioRepositorio.save(new Veterinario("12345678", "Vet1", "password",
                "https://images.ctfassets.net/pdf29us7flmy/69sCM6f2F5THBeBnNewynl/8ed3116aaf346a441d214b9f92748e21/-IND-001-036-_Types_of_Veterinary_Careers_Final.png?w=720&q=100&fm=jpg"));

        estadoMasRepositorio.save(new EstadoMas("Ingresado"));
        estadoMasRepositorio.save(new EstadoMas("De baja"));

        Mascota asociar = mascotaRepositorio.findById(1L).get();
        asociar.setDueno(clienteRepositorio.findById(1L).get());
        asociar.setEstado(estadoMasRepositorio.findById(1L).get());
        mascotaRepositorio.save(asociar);

        asociar = mascotaRepositorio.findById(2L).get();
        asociar.setDueno(clienteRepositorio.findById(1L).get());
        asociar.setEstado(estadoMasRepositorio.findById(1L).get());
        mascotaRepositorio.save(asociar);

        asociar = mascotaRepositorio.findById(3L).get();
        asociar.setDueno(clienteRepositorio.findById(1L).get());
        asociar.setEstado(estadoMasRepositorio.findById(2L).get());
        mascotaRepositorio.save(asociar);

        Cliente asociarCliente = clienteRepositorio.findById(1L).get();
        asociarCliente.setVeterinario(veterinarioRepositorio.findById(1L).get());
        clienteRepositorio.save(asociarCliente);

        asociarCliente = clienteRepositorio.findById(2L).get();
        asociarCliente.setVeterinario(veterinarioRepositorio.findById(1L).get());
        clienteRepositorio.save(asociarCliente);
    }

    //Pruebas para los queries de mascota (2 Pruebas)
    @Test
    public void MascotaRepositorio_findByVeterinarioId_NotEmptyList(){
        
        List<Mascota> mascotasVet1 = mascotaRepositorio.findByVeterinarioId(1L);

        Assertions.assertThat(mascotasVet1).isNotNull();
        Assertions.assertThat(mascotasVet1.size()).isEqualTo(3);
    }

    @Test
    public void MascotaRepositorio_findMascotasActivas_CantMascotasActivas(){
        
        Integer mascotasAct = mascotaRepositorio.findCountMascotasActivas();

        Assertions.assertThat(mascotasAct).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(mascotasAct).isEqualTo(2);
    }

}