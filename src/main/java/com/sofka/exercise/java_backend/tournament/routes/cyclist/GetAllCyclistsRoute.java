package com.sofka.exercise.java_backend.tournament.routes.cyclist;

import com.sofka.exercise.java_backend.tournament.entity.Cyclist;
import com.sofka.exercise.java_backend.tournament.usecases.cyclist.GetAllCyclistsUseCase;
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
public class GetAllCyclistsRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllCyclists(GetAllCyclistsUseCase useCase) {
        return route(GET("/cyclist/getAll"),
                request -> ServerResponse.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromProducer(useCase.apply(), Cyclist.class)));
    }
}
