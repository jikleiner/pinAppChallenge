package com.josekleiner.pinAppChallenge.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="CLIENTES")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_sequence")
	@SequenceGenerator(name = "cliente_sequence", sequenceName = "SEQ_CLIENTES", allocationSize = 1)
	@Column(name="CLIENTE_ID")
	private Long id;
	@Column(name="CLIENTE_NOMBRE")
	private String nombre;
	@Column(name="CLIENTE_APELLIDO")
	private String apellido;
	@Column(name="CLIENTE_EDAD")
	private Long edad;
	@Column(name="CLIENTE_FECHA_NACIMIENTO")
	@Temporal(TemporalType.DATE)
	private Date fechaDeNacimiento;
	
	public Cliente() {
	}
	
	public Cliente(Long id, String nombre, String apellido, Long edad, Date fechaDeNacimiento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public Cliente(ClienteTORest clienteToRest) {
		this.nombre = clienteToRest.getNombre();
		this.apellido = clienteToRest.getApellido();
		this.edad = clienteToRest.getEdad();
		this.fechaDeNacimiento = new Date(clienteToRest.getFechaDeNacimiento().getTime());
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
	
}
