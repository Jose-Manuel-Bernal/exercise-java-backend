package com.sofka.exercise.java_backend.tournament.routes.cyclist;

import com.sofka.exercise.java_backend.tournament.dto.CyclistDTO;
import com.sofka.exercise.java_backend.tournament.usecases.cyclist.PutCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> putCyclist(PutCyclistUseCase useCase) {
        return route(PUT("/cyclist/put").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(CyclistDTO.class)
                        .flatMap(useCase::apply)
                        .flatMap(cyclistDTO -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(cyclistDTO))
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.BAD_REQUEST).build())
        );
    }
}
