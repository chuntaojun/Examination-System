package com.tensor.org.web.handler.work;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
public interface CompileTaskHandler {

    Mono<ServerResponse> compileWork(ServerRequest request);

}
