package com.sofka.exercise.java_backend.tournament.repository;

import com.sofka.exercise.java_backend.tournament.entity.Cyclist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CyclistRepository extends ReactiveMongoRepository<Cyclist, String> {
}
