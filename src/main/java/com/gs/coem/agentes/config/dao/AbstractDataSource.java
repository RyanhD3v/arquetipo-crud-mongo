package com.gs.coem.agentes.config.dao;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
<b>AbstractDataSource.java</b>  clase de conexion
@version: Superapp 1.0
@descripcion: AbstractDataSource
@author: ibrahim, Desarrollador
@ultimaModificacion: 13 jun. 2022 13:41:18
*/
@Configuration
public abstract class AbstractDataSource {
	
	private static final Logger log = LoggerFactory.getLogger(AbstractDataSource.class);

	protected final String MY_DATABASE;
	protected MongoDatabase db;
	protected MongoClient mongoClient;

	/**
	 *
	 * @param mongoClient mongoClient
	 * @param databaseName databaseName
	 * CONSTRUCTOR
	 */
	protected AbstractDataSource(MongoClient mongoClient, String databaseName) {
		log.info("init abstract data-source");
		this.mongoClient = mongoClient;
		MY_DATABASE = databaseName;
		this.db = this.mongoClient.getDatabase(MY_DATABASE);
		
	}

	/**
	 *
	 * @return new ObjectId
	 */
	public ObjectId generateObjectId() {
		return new ObjectId();
	}
}
