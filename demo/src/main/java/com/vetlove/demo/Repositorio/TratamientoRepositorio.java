package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Tratamiento;

@Repository
public interface TratamientoRepositorio extends JpaRepository<Tratamiento, Long>{
    List<Tratamiento> findByMascota(Mascota mascota);
    
    @Query(value = "SELECT t.*\r\n" + //
                "FROM TRATAMIENTO as t\r\n" + //
                "INNER JOIN (\r\n" + //
                "    SELECT cv.ID_CLIENTE as ID_CLIENTE, cv.ID_VETERINARIO, m.ID as ID_MASCOTA\r\n" + //
                "    FROM MASCOTA as m\r\n" + //
                "    INNER JOIN (\r\n" + //
                "        SELECT c.ID as ID_CLIENTE, v.ID_VETERINARIO\r\n" + //
                "        FROM CLIENTE as c\r\n" + //
                "        INNER JOIN (\r\n" + //
                "            SELECT ID_VETERINARIO\r\n" + //
                "            FROM VETERINARIO\r\n" + //
                "            WHERE ID_VETERINARIO = :id\r\n" + //
                "        ) as v\r\n" + //
                "        ON v.ID_VETERINARIO = c.VETERINARIO_ID_VETERINARIO\r\n" + //
                "    ) as cv\r\n" + //
                "    ON m.DUENO_ID = cv.ID_CLIENTE\r\n" + //
                ") as cvm\r\n" + //
                "ON cvm.ID_MASCOTA = t.MASCOTA_ID \r\n" + //
                "WHERE t.MEDICAMENTO_APLICADO = FALSE"
                , nativeQuery = true)
    List<Tratamiento> findByVeterinarioId(@Param("id") Long id);
    //SELECT t.* FROM TRATAMIENTO as t INNER JOIN (     SELECT cv.ID_CLIENTE as ID_CLIENTE, cv.ID_VETERINARIO, m.ID as ID_MASCOTA     FROM MASCOTA as m     INNER JOIN (         SELECT c.ID as ID_CLIENTE, v.ID_VETERINARIO         FROM CLIENTE as c         INNER JOIN (             SELECT ID_VETERINARIO             FROM VETERINARIO             WHERE ID_VETERINARIO = 1         ) as v         ON v.ID_VETERINARIO = c.VETERINARIO_ID_VETERINARIO     ) as cv     ON m.DUENO_ID = cv.ID_CLIENTE ) as cvm ON cvm.ID_MASCOTA = t.MASCOTA_ID t.MEDICAMENTO_APLICADO = FALSE


    @Query(value =  "SELECT COUNT (*) \r\n" + //
                    "FROM TRATAMIENTO\r\n" + //
                    "WHERE FECHA_FIN > DATEADD('MONTH', -1, CURRENT_TIMESTAMP()) AND MEDICAMENTO_APLICADO = TRUE\r\n"
            , nativeQuery = true)
    int findCountTratamientosLastMonth();
    //SELECT COUNT (*) FROM TRATAMIENTO WHERE FECHA_FIN > DATEADD('MONTH', -1, CURRENT_TIMESTAMP()) AND MEDICAMENTO_APLICADO = TRUE
}