package com.josekleiner.pinAppChallenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josekleiner.pinAppChallenge.entity.Cliente;
import com.josekleiner.pinAppChallenge.entity.ClienteTORest;
import com.josekleiner.pinAppChallenge.entity.KpiEdadesClientesTORest;
import com.josekleiner.pinAppChallenge.service.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(path = "/crearCliente")
	@Operation(description = "Crear un cliente", summary = "Retorna el cliente con su Id generado")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "201", description = "Creado exitosamente"),
	  @ApiResponse(responseCode = "400", description = "El cliente no fue creado por error en algun dato o tipo")
	})
	public ResponseEntity<ClienteTORest> altaCliente(@RequestBody ClienteTORest clienteToRest){
		Cliente nuevoCliente;
		try {
			nuevoCliente = clienteService.createCliente(clienteToRest);
			clienteToRest.setId(nuevoCliente.getId());
			return new ResponseEntity<ClienteTORest>(clienteToRest, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<ClienteTORest>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "/{idCliente}")
	@Operation(description = "Obtiene un cliente por Id", summary = "Retorna el cliente solicitado")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Retornado exitosamente"),
	  @ApiResponse(responseCode = "404", description = "No se encontro un cliente para ese Id")
	})
	public ResponseEntity<ClienteTORest> getCliente(@PathVariable Long idCliente){
		ClienteTORest clienteResponse;
		try {
			clienteResponse = clienteService.getCliente(idCliente);
			return new ResponseEntity<ClienteTORest>(clienteResponse, HttpStatus.OK);
		} catch (Exception x) {
			return new ResponseEntity<ClienteTORest>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(path = "/kpideclientes")
	@Operation(description = "Obtiene los valores de KPI (promedio de edades y desvio estandar) de los clientes",
			summary = "Retorna los valores solicitados")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Retornado exitosamente"),
	  @ApiResponse(responseCode = "500", description = "Ocurrio un error en el servicio que impidio el calculo")
	})
	public ResponseEntity<KpiEdadesClientesTORest> getKpiClientes(){
		KpiEdadesClientesTORest response;
		try {
			response = clienteService.getKpiClientes();
			return new ResponseEntity<KpiEdadesClientesTORest>(response, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<KpiEdadesClientesTORest>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/listarclientes")
	@Operation(description = "Obtiene un listado de todos los clientes",
			summary = "Se agrega el valor de fecha probable de muerte a cada uno")
	@ApiResponses(value = {
	  @ApiResponse(responseCode = "200", description = "Retornado exitosamente"),
	  @ApiResponse(responseCode = "500", description = "Ocurrio un error en el servicio que impidio el calculo")
	})
	public ResponseEntity<List<ClienteTORest>> getListaClientes(){
		List<ClienteTORest> listaClientes;
		ResponseEntity<List<ClienteTORest>> payload;
		try {
			listaClientes = clienteService.listarClientes();
			payload = new ResponseEntity<List<ClienteTORest>>(listaClientes, HttpStatus.OK);
			return payload;
		}catch (Exception e) {
			return new ResponseEntity<List<ClienteTORest>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
