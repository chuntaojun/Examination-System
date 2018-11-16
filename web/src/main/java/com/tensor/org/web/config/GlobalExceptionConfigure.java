package com.tensor.org.web.config;

import com.tensor.org.api.ResultData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.Map;

import static com.tensor.org.web.utils.StringsValue.CN.SERVRE_BROKEN_ERR;

/**
 * 全局异常处理
 * @author liaochuntao
 */
@Slf4j
@Configuration
public class GlobalExceptionConfigure {

    @Component
    @Order(-2)
    public class GlobalErrorWebExceptionHandler extends AbstractErrorWebExceptionHandler {

        public GlobalErrorWebExceptionHandler(ErrorAttributes errorAttributes,
                                              ResourceProperties resourceProperties,
                                              ApplicationContext applicationContext,
                                              ServerCodecConfigurer serverCodecConfigurer) {
            super(errorAttributes, resourceProperties, applicationContext);
            super.setMessageWriters(serverCodecConfigurer.getWriters());
            super.setMessageReaders(serverCodecConfigurer.getReaders());
        }

        @Override
        protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
            return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
        }

        private Mono<ServerResponse> renderErrorResponse(ServerRequest request) {
            final Map<String, Object> errorMap = getErrorAttributes(request, true);
            log.error("[内部错误信息]：{}", errorMap);
            Mono<ResultData> errMono = Mono.just(ResultData
                    .builder()
                    .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                    .errMsg(SERVRE_BROKEN_ERR)
                    .builded());
            return ServerResponse.ok().body(BodyInserters
                    .fromPublisher(errMono.publishOn(Schedulers.elastic()), ResultData.class))
                    .subscribeOn(Schedulers.elastic());
        }
    }

}
