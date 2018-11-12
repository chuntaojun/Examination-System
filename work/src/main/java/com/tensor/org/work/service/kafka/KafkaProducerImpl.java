package com.tensor.org.work.service.kafka;

import com.tensor.org.api.kafka.enpity.KafkaMsg;
import com.tensor.org.api.kafka.enpity.KafkaPackage;
import com.tensor.org.work.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
public class KafkaProducerImpl implements KafkaProducer {

    @Autowired private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void producerMsg(KafkaPackage kafkaPackage) {

    }

    protected void publish(String topic, KafkaMsg kafkaMsg) {
        kafkaTemplate.send(topic, JsonUtils.toJson(kafkaMsg)).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {

            }

            @Override
            public void onSuccess(SendResult<String, String> result) {

            }
        });

    }

}
