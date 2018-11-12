package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

/**
 * @author liaochuntao
 */
@Component
@Service(version = "1.0.0",
         application = "${dubbo.application.id}",
         protocol = "${dubbo.protocol.id}",
         registry = "${dubbo.registry.id}")
public class KafkaApiServiceImpl implements com.tensor.org.api.kafka.KafkaApiService {



}
