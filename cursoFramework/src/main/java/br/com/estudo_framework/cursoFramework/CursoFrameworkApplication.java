package br.com.estudo_framework.cursoFramework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.estudo_framework.cursoFramework.model.DadosEpisodio;
import br.com.estudo_framework.cursoFramework.model.DadosSerie;
import br.com.estudo_framework.cursoFramework.model.DadosTemporada;
import br.com.estudo_framework.service.ConsumoApi;
import br.com.estudo_framework.service.ConverterDados;

@SpringBootApplication
public class CursoFrameworkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursoFrameworkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<DadosTemporada> listaTemporadas = new ArrayList<>();
		ConsumoApi consumoAPI = new ConsumoApi();
		var json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&apikey=6585022c");
		ConverterDados conversor = new ConverterDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados.toString());
		json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=1&episode=2&apikey=6585022c");
		DadosEpisodio dadosEpisodio = conversor.obterDados(json, DadosEpisodio.class);
		System.out.println(dadosEpisodio.toString());

		for (int i = 1; i <= dados.totalTemporadas(); i++) {
			json = consumoAPI.obterDados("https://www.omdbapi.com/?t=gilmore+girls&season=" + i + "&apikey=6585022c");
			DadosTemporada dadosTemporada = conversor.obterDados(json, DadosTemporada.class);
			listaTemporadas.add(dadosTemporada);
		}
		listaTemporadas.forEach(System.out::println);

	}
}