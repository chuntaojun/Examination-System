package com.tensor.org.work.service.kafka;

import com.tensor.org.api.kafka.KafkaPackage;

/**
 * @author liaochuntao
 */
public interface KafkaProducer {

    void producerMsg(KafkaPackage kafkaPackage);

}
