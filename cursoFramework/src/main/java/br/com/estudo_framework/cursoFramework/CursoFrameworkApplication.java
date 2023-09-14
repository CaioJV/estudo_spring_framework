package br.com.estudo_framework.cursoFramework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoFrameworkApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursoFrameworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Projeto Spring sem Web");
	}

}
