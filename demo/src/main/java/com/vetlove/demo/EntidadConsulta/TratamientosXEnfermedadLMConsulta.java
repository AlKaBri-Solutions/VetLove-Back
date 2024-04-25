package com.vetlove.demo.EntidadConsulta;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TratamientosXEnfermedadLMConsulta {
	@Id
	private Integer id;

	public TratamientosXEnfermedadLMConsulta() {

    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer cantidad;
	private String nombre;

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
