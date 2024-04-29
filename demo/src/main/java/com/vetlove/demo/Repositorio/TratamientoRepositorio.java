package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.Entidad.Mascota;
import com.vetlove.demo.Entidad.Tratamiento;

@Repository
public interface TratamientoRepositorio extends JpaRepository<Tratamiento, Long>{
    List<Tratamiento> findByMascota(Mascota mascota);
    @Query(value =  "SELECT COUNT (*) \r\n" + //
                    "FROM TRATAMIENTO\r\n" + //
                    "WHERE FECHA_FIN > DATEADD('MONTH', -1, CURRENT_TIMESTAMP()) AND MEDICAMENTO_APLICADO = TRUE\r\n"
            , nativeQuery = true)
    int findCountTratamientosLastMonth();
    //SELECT COUNT (*) FROM TRATAMIENTO WHERE FECHA_FIN > DATEADD('MONTH', -1, CURRENT_TIMESTAMP()) AND MEDICAMENTO_APLICADO = TRUE
}