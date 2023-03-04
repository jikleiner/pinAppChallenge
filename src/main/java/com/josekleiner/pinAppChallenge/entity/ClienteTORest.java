package com.josekleiner.pinAppChallenge.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(value = {"fechaProbableDeMuerte"})
public class ClienteTORest {

	@JsonProperty(required = false)
	private Long id;
	@JsonProperty(required = true)
	private String nombre;
	@JsonProperty(required = true)
	private String apellido;
	@JsonProperty(required = true)
	private Long edad;
	@JsonProperty(required = true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fechaDeNacimiento;
	@JsonProperty(required = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date fechaProbableDeMuerte;
	
	public ClienteTORest(String nombre, String apellido, Long edad, Date fechaDeNacimiento, Date fechaProbableDeMuerte) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaProbableDeMuerte = fechaProbableDeMuerte;
	}

	public ClienteTORest() {
		super();
	}

	public ClienteTORest(Cliente cliente) {
		this.id = cliente.getId();
		this.nombre = cliente.getNombre();
		this.apellido = cliente.getApellido();
		this.edad = cliente.getEdad();
		this.fechaDeNacimiento = cliente.getFechaDeNacimiento();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Long getEdad() {
		return edad;
	}

	public void setEdad(Long edad) {
		this.edad = edad;
	}

	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Date getFechaProbableDeMuerte() {
		return fechaProbableDeMuerte;
	}

	public void setFechaProbableDeMuerte(Date fechaProbableDeMuerte) {
		this.fechaProbableDeMuerte = fechaProbableDeMuerte;
	}
	
}
