package com.tensor.org.web.handler.login;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
@Component
public class LoginHandlerImpl implements LoginHandler {

    @Override
    public Mono<ServerResponse> login(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> logout(ServerRequest request) {
        return null;
    }

    @Override
    public Mono<ServerResponse> register(ServerRequest request) {
        return null;
    }
}
