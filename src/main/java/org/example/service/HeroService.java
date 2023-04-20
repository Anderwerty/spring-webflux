package org.example.service;

import org.example.entity.Hero;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HeroService {

    Mono<Hero> findById(String id);

    Flux<Hero> findAll();
}
