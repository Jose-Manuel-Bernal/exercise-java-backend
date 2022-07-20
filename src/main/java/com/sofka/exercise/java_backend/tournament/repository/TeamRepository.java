package com.sofka.exercise.java_backend.tournament.repository;

import com.sofka.exercise.java_backend.tournament.entity.Team;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends ReactiveMongoRepository<Team, String> {
}
