package br.com.estudo_framework.cursoFramework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudo_framework.service.ConsumoApi;

@SpringBootApplication
public class CursoFrameworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursoFrameworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Primeiro projeto Spring sem Web");
		ConsumoApi consumoAPI = new ConsumoApi();
		var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		System.out.println(json);
	}

}
