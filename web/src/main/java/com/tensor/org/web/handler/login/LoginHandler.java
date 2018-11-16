package com.tensor.org.web.handler.login;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
public interface LoginHandler {

    Mono<ServerResponse> login(ServerRequest request);

    Mono<ServerResponse> logout(ServerRequest request);

    Mono<ServerResponse> register(ServerRequest request);

}
