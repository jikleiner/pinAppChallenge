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
import io.swagger.annotations.*;

import com.josekleiner.pinAppChallenge.entity.Cliente;
import com.josekleiner.pinAppChallenge.entity.ClienteTORest;
import com.josekleiner.pinAppChallenge.entity.KpiEdadesClientesTORest;
import com.josekleiner.pinAppChallenge.service.ClienteService;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping(path = "/crearCliente")
	
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
	public ResponseEntity<ClienteTORest> getCliente(@PathVariable Long idCliente){
		ClienteTORest clienteResponse;
		try {
			clienteResponse = clienteService.getCliente(idCliente);
			return new ResponseEntity<ClienteTORest>(clienteResponse, HttpStatus.OK);
		} catch (Exception x) {
			return new ResponseEntity<ClienteTORest>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping(path = "/kpideclientes")
	public ResponseEntity<KpiEdadesClientesTORest> getKpiClientes(){
		return null;
	}
	
	@GetMapping(path = "/listarclientes")
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
