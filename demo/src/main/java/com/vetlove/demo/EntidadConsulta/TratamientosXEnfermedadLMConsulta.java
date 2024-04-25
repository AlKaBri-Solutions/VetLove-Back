package com.vetlove.demo.EntidadConsulta;

public class TratamientosXEnfermedadLMConsulta {
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
