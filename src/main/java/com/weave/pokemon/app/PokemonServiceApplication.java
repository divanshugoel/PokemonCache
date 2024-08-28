package com.weave.pokemon.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages =  "com.weave.pokemon")
public class PokemonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonServiceApplication.class, args);
	}

}
