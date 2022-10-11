package br.edu.ifpb.dac.projetomvc;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoMvcApplication implements WebMvcConfigurer{

	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoMvcApplication.class, args);
	}

	public void addCorMappings(corsRegistry registry){
		registry
			.addMapping("/**")
			.allowedMethods("GET","POST","DELETE","OPTIONS","PATCH");
	}
}
