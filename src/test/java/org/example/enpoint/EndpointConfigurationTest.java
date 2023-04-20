package org.example.enpoint;

import org.example.Runner;
import org.example.entity.Hero;
import org.example.repository.HeroRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = Runner.class)
class EndpointConfigurationTest {

    @Autowired
    private EndpointConfiguration endpointConfiguration;

    @MockBean
    private HeroRepository heroRepository;


    @Test
    void getAllHeroesShouldReturnNotEmptyHeroesList(){
        WebTestClient webTestClient = WebTestClient.bindToRouterFunction(endpointConfiguration.getAllHeroes()).build();

        Hero hero1 = Hero.builder().id("1").fullName("hero 1").callSing("hero 1").build();
        Hero hero2 = Hero.builder().id("2").fullName("hero 2").callSing("hero 2").build();

        List<Hero> heroes = List.of(hero1, hero2);

        Mockito.when(heroRepository.findAll()).thenReturn(heroes);

        webTestClient
                .get()
                .uri("/heroes")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Hero.class)
                .isEqualTo(heroes);


    }
}