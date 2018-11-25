package com.tensor.org.web.utils;

import com.alibaba.dubbo.remoting.Server;
import com.tensor.org.api.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

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
    public static Mono<ServerResponse> renderImmediatel(Mono<ResultData> dataMono, HttpStatus httpStatus) {
        return ServerResponse
                .status(httpStatus)
                .header("Access-Control-Allow-Origin", "*")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(dataMono.publishOn(Schedulers.immediate()), ResultData.class))
                .subscribeOn(Schedulers.immediate());
    }

    public static Mono<ServerResponse> render(Mono<ResultData> dataMono, HttpStatus status) {
        return ServerResponse
                .status(status)
                .header("Access-Control-Allow-Origin", "*")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(dataMono.publishOn(Schedulers.elastic()), ResultData.class))
                .subscribeOn(Schedulers.elastic());
    }

    public static Mono<ServerResponse> render(Mono<ResultData> dataMono) {
        return ok()
                .header("Access-Control-Allow-Origin", "*")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(dataMono.publishOn(Schedulers.elastic()), ResultData.class))
                .subscribeOn(Schedulers.elastic());
    }

}
