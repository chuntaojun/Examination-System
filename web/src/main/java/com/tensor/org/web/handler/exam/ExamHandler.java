package com.tensor.org.web.handler.exam;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @author liaochuntao
 */
public interface ExamHandler {

    /**
     *
     * @param request
     * @return
     */
    Mono<ServerResponse> addQues(ServerRequest request);

}
