package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Cliente;
import com.vetlove.demo.Entidad.Mascota;

@Repository
public interface MascotaRepositorio extends JpaRepository<Mascota, Long> {
    List<Mascota> findByDueno(Cliente dueno);
    @Query(value = "SELECT * \r\n" + //
                "FROM MASCOTA m \r\n" + //
                "INNER JOIN \r\n" + //
                "    (SELECT ID as cId, VETERINARIO_ID_VETERINARIO as vId\r\n" + //
                "    FROM CLIENTE c \r\n" + //
                "    INNER JOIN \r\n" + //
                "        (SELECT *\r\n" + //
                "        FROM VETERINARIO) v \r\n" + //
                "    ON c.VETERINARIO_ID_VETERINARIO = v.ID_VETERINARIO) vc \r\n" + //
                "ON m.DUENO_ID = vc.cId\r\n" + //
                "WHERE VC.vId= :id"
            , nativeQuery = true)
    List<Mascota> findByVeterinarioId(@Param("id") Long id);

    @Query(value = "SELECT COUNT(*)\r\n" + //
                    "FROM MASCOTA\r\n"
            , nativeQuery = true)
    int findCountMascotas();

    @Query(value = "SELECT COUNT(*) \r\n" + //
    "FROM MASCOTA \r\n" + //
    "WHERE ESTADO_ID = 1 \r\n"
    , nativeQuery = true)
    int findCountMascotasActivas();
    //SELECT COUNT(*) FROM MASCOTA WHERE ESTADO_ID = 1
}