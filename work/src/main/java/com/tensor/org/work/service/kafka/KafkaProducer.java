package com.tensor.org.work.service.kafka;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.notice.KafkaPackage;

/**
 * @author liaochuntao
 */
public interface KafkaProducer {

    ResultData producerMsg(KafkaPackage kafkaPackage);

}
