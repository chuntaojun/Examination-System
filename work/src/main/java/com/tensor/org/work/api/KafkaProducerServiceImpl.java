package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.kafka.KafkaProducerService;
import com.tensor.org.api.kafka.KafkaPackage;
import com.tensor.org.work.service.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liaochuntao
 */
@Service(version = "1.0.0",
         application = "${dubbo.application.id}",
         protocol = "${dubbo.protocol.id}",
         registry = "${dubbo.registry.id}")
@Component
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Autowired private KafkaProducer kafkaProducer;

    @Override
    public ResultData sendDataToKafka(KafkaPackage kafkaPackage) {
        kafkaProducer.producerMsg(kafkaPackage);
        return null;
    }
}
