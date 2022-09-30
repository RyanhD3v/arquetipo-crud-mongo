package com.gs.coem.agentes.services.impl.cliente;

import com.gs.coem.agentes.config.dao.ClientesRepository;
import com.gs.coem.agentes.entity.Clientes;
import com.gs.coem.agentes.services.impl.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ClientesServiceImpl implements ClientesService {

	private static final Logger log = Logger.getLogger(String.valueOf(ClientesServiceImpl.class));
	@Autowired
	private ClientesRepository clientesRepository;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public Clientes guardarCliente(Clientes clienteEntity) {
		return clientesRepository.save(clienteEntity);
	}

	public List<Clientes> getClientes(){

		return null;
	}
	@Override
	public Clientes consultarCliente(String id) {

		return clientesRepository.findById(id)
				.orElseThrow(() -> new ClienteNoEncontradoException("No se encontro el cliente : " , id));
	}

	@Override
	public void borrarCliente(String id) {

		clientesRepository.deleteById(id);

	}


	@Override
	public Clientes actualizarCliente(String id, Clientes clienteEntity){

		clientesRepository.findById(id)
				.orElseThrow(() -> new ClienteNoEncontradoException("No se encontro el cliente : " , id));

		Clientes cliente = new Clientes();
		cliente.setId(id);
		cliente.setNombre(clienteEntity.getNombre());
		cliente.setApellidoP(clienteEntity.getApellidoP());
		cliente.setApellidoM(clienteEntity.getApellidoM());
		cliente.setEdad(clienteEntity.getEdad());
		cliente.setTelefonoM(clienteEntity.getTelefonoM());
		cliente.setEmail(clienteEntity.getEmail());
		cliente.setStatus(clienteEntity.getStatus());

		return clientesRepository.save(cliente);
	}

}
