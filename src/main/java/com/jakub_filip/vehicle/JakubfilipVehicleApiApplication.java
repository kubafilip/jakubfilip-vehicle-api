package com.jakub_filip.vehicle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EntityScan("com.jakub_filip.vehicle")
@EnableWebMvc
@EnableJpaRepositories("com.jakub_filip.vehicle")
public class JakubfilipVehicleApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JakubfilipVehicleApiApplication.class, args);
		System.out.println("HELLO WORLD");
	}

}
