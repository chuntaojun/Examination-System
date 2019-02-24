package com.tensor.org.web.handler.notice;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
public interface NoticeHandler {

    Mono<ServerResponse> publish(ServerRequest request);

}
