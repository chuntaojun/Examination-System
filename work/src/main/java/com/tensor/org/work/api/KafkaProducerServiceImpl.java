package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.kafka.KafkaProducerService;
import com.tensor.org.api.kafka.KafkaPackage;
import org.springframework.stereotype.Component;

/**
 * @author liaochuntao
 */
@Component
@Service(version = "1.0.0",
         application = "${dubbo.application.id}",
         protocol = "${dubbo.protocol.id}",
         registry = "${dubbo.registry.id}")
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Override
    public ResultData sendDataToKafka(KafkaPackage kafkaPackage) {
        return null;
    }
}
