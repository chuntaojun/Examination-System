package com.tensor.org.web.router;

import com.tensor.org.web.handler.login.LoginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author liaochuntao
 */
@Configuration
public class ApiLoginRouter {

    @Autowired private LoginHandler loginHandler;

    @Bean(value = "LoginApiRouter")
    public RouterFunction<?> loginApiRouter() {
        return route(
                POST("/v1/api/login/{type}"), loginHandler::login);
    }

}
