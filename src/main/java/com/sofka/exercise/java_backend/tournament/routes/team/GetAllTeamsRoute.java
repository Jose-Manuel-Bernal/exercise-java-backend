package com.sofka.exercise.java_backend.tournament.routes.team;

import com.sofka.exercise.java_backend.tournament.entity.Team;
import com.sofka.exercise.java_backend.tournament.usecases.team.GetAllTeamsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetAllTeamsRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllTeams(GetAllTeamsUseCase useCase) {
        return route(GET("/team/getAll"),
                request -> ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(useCase.apply(), Team.class)));
    }
}
