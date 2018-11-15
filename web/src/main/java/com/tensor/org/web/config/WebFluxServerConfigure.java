package com.tensor.org.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import reactor.netty.http.server.HttpServer;

import java.util.Objects;

/**
 * @author liaochuntao
 */
@Configuration
public class HttpServerConfigure {

    @Autowired private Environment environment;

    @Bean
    public HttpServer httpServer(@Qualifier(value = "UserApiRouter")RouterFunction<?> routerFunction) {
        return getHttpServer(routerFunction);
    }

    private HttpServer getHttpServer(RouterFunction<?> routerFunction) {
        HttpHandler handler = RouterFunctions.toHttpHandler(routerFunction);
        ReactorHttpHandlerAdapter httpHandlerAdapter = new ReactorHttpHandlerAdapter(handler);
        HttpServer httpServer = HttpServer
                .create()
                .host("localhost")
                .port(Integer.valueOf(Objects.requireNonNull(environment.getProperty("server.port"))));
        httpServer.handle(httpHandlerAdapter);
        return httpServer;
    }

}
