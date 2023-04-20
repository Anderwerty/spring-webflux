package org.example.repository.impl;

import org.example.entity.Hero;
import org.example.repository.HeroRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class HeroInMemoryRepository implements HeroRepository {

    private static final Map<String, Hero> ID_TO_HERO = new HashMap<>();

    static {
        ID_TO_HERO.put("1", Hero.builder()
                .id("1")
                .fullName("Данііл Лашук")
                .callSing("Маджахет")
                .build()

        );

        ID_TO_HERO.put("2", Hero.builder()
                .id("2")
                .fullName("Бабич Роман")
                .callSing("Диск")
                .build()

        );
    }

    @Override
    public List<Hero> findAll() {
        return ID_TO_HERO.values().stream().toList();
    }

    @Override
    public Optional<Hero> findById(String id) {
        return Optional.ofNullable(ID_TO_HERO.get(id));
    }
}
