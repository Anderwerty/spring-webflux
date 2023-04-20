package org.example.enpoint;

import org.example.entity.Hero;
import org.example.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class EndpointConfiguration {

    @Autowired
    private HeroService heroService;


    @Bean
    public RouterFunction<ServerResponse> getHeroById() {
        return RouterFunctions.route(RequestPredicates.GET("/heroes/{id}"),
                request -> ServerResponse.ok().body(heroService.findById(request.pathVariable("id")), Hero.class));
    }


    @Bean
    public RouterFunction<ServerResponse> getAllHeroes() {
        return RouterFunctions.route(RequestPredicates.GET("/heroes"),
                request -> ServerResponse.ok().body(heroService.findAll(), Hero.class));
    }

}
