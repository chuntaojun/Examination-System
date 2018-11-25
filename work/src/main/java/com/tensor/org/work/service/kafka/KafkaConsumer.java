package com.tensor.org.work.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author liaochuntao
 */
public interface KafkaConsumer {

    void receive(ConsumerRecord<String, String> record);

}
