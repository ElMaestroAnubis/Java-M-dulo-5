package com.dev.senior;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dev.senior.Repository.PeliculaRepository;
import com.dev.senior.Service.PeliculaService;
import com.dev.senior.Service.PeliculaServiceImpl;

@SpringBootApplication
public class SeniorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeniorApplication.class, args);
	}

	@Bean
	public PeliculaRepository peliculaRepository() {
		return new PeliculaRepository();
	}

	@Bean
	public PeliculaService peliculaService(PeliculaRepository repository) {
		return new PeliculaServiceImpl(repository);		
	}


}