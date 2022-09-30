package com.gs.coem.agentes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class EntityServiceAgentesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntityServiceAgentesApplication.class, args);
		
	}

}
