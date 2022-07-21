package com.sofka.exercise.java_backend.tournament.routes.cyclist;

import com.sofka.exercise.java_backend.tournament.usecases.cyclist.DeleteCyclistUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteCyclistRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteCyclist(DeleteCyclistUseCase useCase) {
        return route(DELETE("/cyclist/delete/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> useCase.apply(request.pathVariable("id"))
                        .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build())
                        .onErrorResume(throwable -> ServerResponse.status(HttpStatus.NOT_FOUND).build())
        );
    }
}
