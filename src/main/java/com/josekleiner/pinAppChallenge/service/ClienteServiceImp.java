package com.josekleiner.pinAppChallenge.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.josekleiner.pinAppChallenge.entity.Cliente;
import com.josekleiner.pinAppChallenge.entity.ClienteTORest;
import com.josekleiner.pinAppChallenge.entity.KpiEdadesClientesTORest;
import com.josekleiner.pinAppChallenge.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Value(value = "${edad.promedio.de.muerte.argentina}")
	private String edadPromedioDeMuerteArgentina;
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Cliente createCliente(ClienteTORest clienteTORest) {
		Cliente nuevoCliente = new Cliente(clienteTORest);
		clienteRepository.save(nuevoCliente);
		return nuevoCliente;
	}

	@Override
	public ClienteTORest getCliente(Long idCliente) {
		return new ClienteTORest(clienteRepository.getReferenceById(idCliente));
	}
	
	@Override
	public KpiEdadesClientesTORest getKpiClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		KpiEdadesClientesTORest kpiTORest = new KpiEdadesClientesTORest();
		kpiTORest.setPromedioEdadesClientes(getPromedioEdadesClientes(clientes));
		kpiTORest.setDesviacionEstandarEdadesClientes(getDesviacionEstandarEdadesClientes(clientes, kpiTORest.getPromedioEdadesClientes()));
		return kpiTORest;
	}

	private Double getPromedioEdadesClientes(List<Cliente> clientes) {
		Double contadorClientes = 0D;
		Double acomuladorEdades = 0D;
		Double promedioEdades = 0.0D;
		for (Cliente cliente : clientes) {
			contadorClientes++;
			acomuladorEdades = acomuladorEdades + cliente.getEdad();
		}
		promedioEdades = acomuladorEdades / contadorClientes;
		return promedioEdades;
	}
	
	private Double getDesviacionEstandarEdadesClientes(List<Cliente> clientes, Double promedioEdades) {
		Double contadorClientes = 0D;
		Double acumuladorCuadrados = 0D;
		for (Cliente cliente : clientes) {
			Double cuadradoEdadCliente = Math.pow( (double)cliente.getEdad() - promedioEdades, 2D);
			acumuladorCuadrados =+ cuadradoEdadCliente;
			contadorClientes++;
		}
		return acumuladorCuadrados/contadorClientes;
	}

	@Override
	public List<ClienteTORest> listarClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteTORest> clientesTORest = new ArrayList<ClienteTORest>();
		for (Cliente cliente : clientes) {
			ClienteTORest clienteTORest = new ClienteTORest(cliente);
			calcularFechaProbableDeMuerte(clienteTORest);
			clientesTORest.add(clienteTORest);
		}
		return clientesTORest;
	}
	
	public void calcularFechaProbableDeMuerte(ClienteTORest clienteTORest) {
		// obtenemos la representacion de año, mes y dia del promedio de edad de muerte en valor entero
		// src: https://datosmacro.expansion.com/demografia/esperanza-vida/argentina
		int añosPromedio = Integer.parseInt(edadPromedioDeMuerteArgentina.substring(0, edadPromedioDeMuerteArgentina.indexOf(".")));
		Double divisionMeses = Double.parseDouble(edadPromedioDeMuerteArgentina) - añosPromedio;
		int mesesPromedio = (int) (divisionMeses * 12);
		Double divisionDias = (divisionMeses * 12) - mesesPromedio;
		int diasPromedio = (int) (divisionDias * 30);
		
		// obtenemos la zona horaria
		ZoneId defaultZoneId = ZoneId.systemDefault();
				
		// se agregan la cantidad de años, meses y dias a la fecha de nacimiento
		LocalDate fechaProbableDeMuerte = Instant.ofEpochMilli(clienteTORest.getFechaDeNacimiento().getTime())
				.atZone(defaultZoneId).toLocalDate()
				.plusYears(añosPromedio)
				.plusMonths(mesesPromedio)
				.plusDays(diasPromedio);
		
		clienteTORest.setFechaProbableDeMuerte(Date.from(fechaProbableDeMuerte.atStartOfDay()
			      .atZone(defaultZoneId)
			      .toInstant()));
	}

}
