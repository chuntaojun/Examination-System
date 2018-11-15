package com.tensor.org.web.handler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tensor.org.api.kafka.KafkaMsg;
import com.tensor.org.api.kafka.KafkaPackage;
import com.tensor.org.api.kafka.KafkaProducerService;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.UUID;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author liaochuntao
 */
@Component
public class ExamHandlerImpl implements ExamHandler {

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "dubbo://192.168.31.217:20880")
    private KafkaProducerService producerService;

    @Override
    public Mono<ServerResponse> addQues(ServerRequest request) {
        producerService.sendDataToKafka(KafkaPackage
                .builder()
                .kafkaMsg(KafkaMsg.builder()
                        .id(UUID.randomUUID().toString())
                        .body("MMP")
                        .sendTime(new Date())
                        .builded())
                .topic("topic")
                .builded());
        return ok().build();
    }
}
