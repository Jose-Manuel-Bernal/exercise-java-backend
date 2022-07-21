package com.sofka.exercise.java_backend.tournament.repository;

import com.sofka.exercise.java_backend.tournament.entity.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team, String> {
    Flux<Team> findByCountry(String country);
    Mono<Team> findByTeamCode(String teamCode);
    Mono<Boolean> existsByTeamCode(String teamCode);
}
