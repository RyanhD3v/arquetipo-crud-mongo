package com.gs.coem.agentes.services.impl;

import com.gs.coem.agentes.entity.Clientes;

public interface ClientesService {

	Clientes guardarCliente(Clientes id);

	Clientes consultarCliente(String id);

	void borrarCliente(String id);

	Clientes actualizarCliente(String id, Clientes cliente);


}
