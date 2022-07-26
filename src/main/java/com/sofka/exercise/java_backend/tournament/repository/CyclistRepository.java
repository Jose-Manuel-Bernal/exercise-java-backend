package com.sofka.exercise.java_backend.tournament.repository;

import com.sofka.exercise.java_backend.tournament.entity.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {
    Mono<Boolean> existsByNumber(Integer number);
    Flux<Cyclist> findByTeamCode(String teamCode);
    Flux<Cyclist> findByCountry(String country);
    Mono<Cyclist> findByNumber(Integer number);
}
