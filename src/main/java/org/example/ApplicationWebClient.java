package org.example;

import org.example.entity.Hero;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ApplicationWebClient {
    private final WebClient webClient = WebClient.create("http://localhost:8080");


    public void run(){

        Flux<Hero> heroFlux = webClient.get()
                .uri("/heroes")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(Hero.class);

        Mono<Hero> heroMono = webClient.get().uri("/heroes/{id}", "2")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Hero.class);



    }
}
