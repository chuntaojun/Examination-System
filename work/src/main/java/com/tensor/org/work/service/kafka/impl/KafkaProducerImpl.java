package com.tensor.org.work.service.kafka.impl;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.kafka.KafkaMsg;
import com.tensor.org.api.kafka.KafkaPackage;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.work.service.kafka.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Service(value = "KafkaProducer")
public class KafkaProducerImpl implements KafkaProducer {

    @Autowired private KafkaTemplate<String, String> kafkaTemplate;
    private static final int MAX_RETRY_TIMES = 3;

    @Override
    public ResultData producerMsg(KafkaPackage kafkaPackage) {
        publish(kafkaPackage.getTopic(), kafkaPackage.getKafkaMsg());
        return ResultData.builder().builded();
    }

    /**
     * 日志操作记录
     * @param topic
     * @param kafkaMsg
     */
    protected void publish(String topic, KafkaMsg kafkaMsg) {
        AtomicInteger retry = new AtomicInteger(0);
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, JsonUtils.toJson(kafkaMsg));
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                while (retry.get() != MAX_RETRY_TIMES) {
                    retry.incrementAndGet();
                }
                log.error("kafka send failure : {}", ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
            }
        });
    }

}
