package com.tensor.org.web.utils;

import com.tensor.org.api.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * @author liaochuntao
 */
public class ResponseAdaperUtils {

    /**
     *
     * @param dataMono
     * @param httpStatus
     * @return
     */
    public Mono<ServerResponse> renderImmediatel(Mono<ResultData> dataMono, HttpStatus httpStatus) {
        return ServerResponse
                .status(httpStatus)
                .header("Access-Control-Allow-Origin", "*")
                .body(BodyInserters.fromPublisher(dataMono.publishOn(Schedulers.elastic()), ResultData.class))
                .subscribeOn(Schedulers.elastic());
    }

}
