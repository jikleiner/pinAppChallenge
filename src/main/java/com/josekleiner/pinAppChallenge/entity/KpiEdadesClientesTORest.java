package com.josekleiner.pinAppChallenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KpiEdadesClientesTORest {
	
	@JsonProperty(required = true)
	private Double promedioEdadesClientes;
	@JsonProperty(required = true)
	private Double desviacionEstandarEdadesClientes;
	
	public KpiEdadesClientesTORest(Double promedioEdadesClientes, Double desviacionEstandarEdadesClientes) {
		this.promedioEdadesClientes = promedioEdadesClientes;
		this.desviacionEstandarEdadesClientes = desviacionEstandarEdadesClientes;
	}
	
	public KpiEdadesClientesTORest() {
		super();
	}

	public Double getPromedioEdadesClientes() {
		return promedioEdadesClientes;
	}
	public void setPromedioEdadesClientes(Double promedioEdadesClientes) {
		this.promedioEdadesClientes = promedioEdadesClientes;
	}
	public Double getDesviacionEstandarEdadesClientes() {
		return desviacionEstandarEdadesClientes;
	}
	public void setDesviacionEstandarEdadesClientes(Double desviacionEstandarEdadesClientes) {
		this.desviacionEstandarEdadesClientes = desviacionEstandarEdadesClientes;
	}
	
}
