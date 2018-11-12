package com.tensor.org.web.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class ApiUserRouter {

    @Bean(value = "UserApiRouter")
    public RouterFunction<?> userApiRouter() {
        return route(
                GET("/api"), request -> ok().body(BodyInserters.fromObject("")));
    }

}
