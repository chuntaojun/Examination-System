package com.tensor.org.web.handler.file;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
public interface FileHandler {

    Mono<ServerResponse> chunkCheck(ServerRequest request);

    Mono<ServerResponse> chunkSave(ServerRequest request);

    Mono<ServerResponse> merge(ServerRequest request);

}
