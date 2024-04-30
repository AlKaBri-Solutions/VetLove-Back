package com.vetlove.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.vetlove.demo.EntidadConsulta.TratamientosXEnfermedadLMConsulta;


@Repository
public interface TratamientosXEnfermedadLMConsultaRepositorio extends JpaRepository<TratamientosXEnfermedadLMConsulta, String>{
    @Query(value="  SELECT a.CANTIDAD, b.NOMBRE \r\n" + //
                    "FROM ENFERMEDAD as b \r\n" + //
                    "INNER JOIN ( \r\n" + //
                        "SELECT COUNT(t.MASCOTA_ID) as CANTIDAD, c.ENFERMEDAD_ID_ENFERMEDAD as ID_ENFERMEDAD \r\n" + //
                        "FROM TRATAMIENTO as t \r\n" + //
                        "INNER JOIN ( \r\n" + //
                            "SELECT ENFERMEDAD_ID_ENFERMEDAD, ID_MEDICAMENTO, UNIDADES \r\n" + //
                            "FROM MEDICAMENTO \r\n" + //
                            ") as c \r\n" + //
                        "ON t.MEDICAMENTO_ID_MEDICAMENTO = c.ID_MEDICAMENTO \r\n" + //
                        "WHERE t.FECHA_FIN > DATEADD('MONTH', -1, CURRENT_TIMESTAMP())  \r\n" + //
                        "GROUP BY c.ENFERMEDAD_ID_ENFERMEDAD \r\n" + //
                    ") as a \r\n" + //
                    "ON a.ID_ENFERMEDAD = b.ID_ENFERMEDAD \r\n"
    , nativeQuery = true)
    List<TratamientosXEnfermedadLMConsulta> findTratameintosXEnfermedadLastMonth();
    //SELECT a.CANTIDAD as cantidad, b.NOMBRE as nombre FROM ENFERMEDAD as b INNER JOIN ( SELECT COUNT(t.MASCOTA_ID) as CANTIDAD, c.ENFERMEDAD_ID_ENFERMEDAD as ID_ENFERMEDAD FROM TRATAMIENTO as t INNER JOIN ( SELECT ENFERMEDAD_ID_ENFERMEDAD, ID_MEDICAMENTO, UNIDADES FROM MEDICAMENTO ) as c ON t.MEDICAMENTO_ID_MEDICAMENTO = c.ID_MEDICAMENTO WHERE t.FECHA_FIN > DATEADD('MONTH', -1, CURRENT_TIMESTAMP())  GROUP BY c.ENFERMEDAD_ID_ENFERMEDAD ) as a ON a.ID_ENFERMEDAD = b.ID_ENFERMEDAD;
}