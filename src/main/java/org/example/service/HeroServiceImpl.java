package org.example.service;

import org.example.entity.Hero;
import org.example.repository.HeroRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroServiceImpl implements HeroService {

    private final HeroRepository heroRepository;

    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public Mono<Hero> findById(String id) {
        return Mono.just(heroRepository.findById(id).orElseThrow());
    }

    @Override
    public Flux<Hero> findAll() {
        return Flux.fromIterable(heroRepository.findAll());
    }
}
