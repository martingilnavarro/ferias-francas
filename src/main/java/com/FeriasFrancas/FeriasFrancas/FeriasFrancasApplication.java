package com.FeriasFrancas.FeriasFrancas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FeriasFrancasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeriasFrancasApplication.class, args);
	}

}