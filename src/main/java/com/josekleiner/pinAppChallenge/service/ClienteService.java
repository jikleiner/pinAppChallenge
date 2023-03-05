package com.josekleiner.pinAppChallenge.service;

import java.util.List;

import com.josekleiner.pinAppChallenge.entity.Cliente;
import com.josekleiner.pinAppChallenge.entity.ClienteTORest;
import com.josekleiner.pinAppChallenge.entity.KpiEdadesClientesTORest;

public interface ClienteService {

	public Cliente createCliente(ClienteTORest clienteTORest);
	public KpiEdadesClientesTORest getKpiClientes();
	public List<ClienteTORest> listarClientes();
	public ClienteTORest getCliente(Long idCliente);
}
