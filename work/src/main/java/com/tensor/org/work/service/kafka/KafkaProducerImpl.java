package com.tensor.org.work.service.kafka;

import com.tensor.org.api.kafka.KafkaMsg;
import com.tensor.org.api.kafka.KafkaPackage;
import com.tensor.org.api.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Service(value = "KafkaProducer")
public class KafkaProducerImpl implements KafkaProducer {

    @Autowired private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void producerMsg(KafkaPackage kafkaPackage) {
        publish(kafkaPackage.getTopic(), kafkaPackage.getKafkaMsg());
    }

    /**
     * 日志操作记录
     * @param topic
     * @param kafkaMsg
     */
    protected void publish(String topic, KafkaMsg kafkaMsg) {
        kafkaTemplate.send(topic, JsonUtils.toJson(kafkaMsg)).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error(ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("result : {}", result);
            }
        });

    }

}
