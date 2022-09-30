package com.gs.coem.agentes.config.dao;

import com.gs.coem.agentes.entity.Clientes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientesRepository extends MongoRepository<Clientes, String> {

	Optional<Clientes> findById(@Param("id") String id);

}
