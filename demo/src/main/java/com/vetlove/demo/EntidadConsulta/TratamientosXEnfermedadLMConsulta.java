package com.vetlove.demo.EntidadConsulta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TratamientosXEnfermedadLMConsulta {
	@Id
	private String nombre;
	private Integer cantidad;
	
	
	public TratamientosXEnfermedadLMConsulta() {

    }

	public TratamientosXEnfermedadLMConsulta(Integer cantidad, String nombre) {
		this.cantidad = cantidad;
		this.nombre = nombre;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
