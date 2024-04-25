package com.vetlove.demo.EntidadConsulta;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.SqlResultSetMapping;

@SqlResultSetMapping(name = "CustomResultMapping", classes = {
        @ConstructorResult(
            targetClass = TratamientosXEnfermedadLMConsulta.class, columns = {
                @ColumnResult(name = "cantidad", type = String.class),
                @ColumnResult(name = "nombre", type = Integer.class),

        }),
        
})
public class CustomResultSetMappings {
    // This class can remain empty, as it serves only to define the mapping
}