package com.gs.coem.agentes.config.dao;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * <b>MongoDatasource.java</b> Clase provider document conexion
 *
 * @version: Superapp 1.0
 * @descripcion: breve descripcion del requerimiento o fix
 * @author: ibrahim, Desarrollador
 * @ultimaModificacion: 27 jul. 2022 8:41:19
 */
@Configuration
public class MongoDatasource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MongoDatasource.class);

    @Value("${spring.data.mongodb.uri}")
    private String connectionStringLocal;

    @Value("${app.env}")
    private String env;

    @Value("${jks.path}")
    private String jksPath;

    @Value("${jks.truststore_password}")
    private String truststorePassword;
    private String username;

    private String password;

    private String clusterEndpoint;

    private String template;

    /**
     * @param username        username
     * @param password        password
     * @param clusterEndpoint clusterEndpoint
     * @param template        template
     */
    public MongoDatasource(@Value("${mongodb.database.user}") String username,
                           @Value("${mongodb.database.password}") String password,
                           @Value("${mongodb.database.endpoint}") String clusterEndpoint,
                           @Value("${mongodb.database.template}") String template) {
        this.username = username;
        this.password = password;
        this.clusterEndpoint = clusterEndpoint;
        this.template = template;
    }

    /**
     * @return MongoClient mongoClient
     */
    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public MongoClient mongoClient() {
        String readPreference = "secondaryPreferred";

        if (!env.equals("local")) {
            String connectionString = String.format(this.template, this.username, this.password, this.clusterEndpoint,
                    readPreference);
            LOGGER.info("Mongo url {}", connectionString);
            LOGGER.info("url jks {}", jksPath);
            System.setProperty("javax.net.ssl.trustStore", jksPath);
            System.setProperty("javax.net.ssl.trustStorePassword", truststorePassword);

            ConnectionString connString = new ConnectionString(connectionString);

            MongoClient mongoClient = MongoClients.create(connString);
            return mongoClient;

        }
        else {
            LOGGER.info("LOCAL");
            ConnectionString connString = new ConnectionString(connectionStringLocal);
            MongoClient mongoClient = MongoClients.create(connString);
            return mongoClient;
        }

    }

}
