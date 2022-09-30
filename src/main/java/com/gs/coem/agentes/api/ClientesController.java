package com.gs.coem.agentes.api;

import com.gs.coem.agentes.entity.Clientes;
import com.gs.coem.agentes.services.impl.cliente.ClientesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("api/clientes/v1")
public class ClientesController {

	private static final Logger log = Logger.getLogger(String.valueOf(ClientesController.class));
	@Autowired
	private ClientesServiceImpl clientesService;

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public Clientes leer(@PathVariable("id") String id) {
		log.info(">>> api/clientes/v1 buscando clientes");

		return clientesService.consultarCliente(id);
	}

	@GetMapping()
	@ResponseStatus(OK)
	public Clientes leerClientes() {
		log.info(">>> api/clientes/v1 Obtener todos los clientes");

		return (Clientes) clientesService.getClientes();
	}

	@PostMapping
	@ResponseStatus(CREATED)
	public Clientes crear(@RequestBody Clientes cliente) {
		log.info(">>> api/clientes/v1 creando clientes");
		return clientesService.guardarCliente(cliente);
	}

	@PutMapping("/{id}")
	@ResponseStatus(OK)
	public Clientes actualizar(@PathVariable("id") String id, @RequestBody Clientes cliente){
		log.info(">>> api/clientes/v1 actualizando cliente");
		return clientesService.actualizarCliente(id, cliente);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(NO_CONTENT)
	public void borrar(@PathVariable("id") String id) {
		clientesService.borrarCliente(id);
	}

}
