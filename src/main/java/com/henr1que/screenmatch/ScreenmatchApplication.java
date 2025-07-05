package com.henr1que.screenmatch;

import com.henr1que.screenmatch.model.DadosSerie;
import com.henr1que.screenmatch.service.ConsumoAPI;
import com.henr1que.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        var consumoAPI = new ConsumoAPI();
        var json = consumoAPI.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=b94057ce");

        ConverteDados conversor = new ConverteDados();

        var dadosSerie = conversor.obterDados(json, DadosSerie.class);
        System.out.println(dadosSerie);
    }
}
