package com.tensor.org.api.kafka;

import com.tensor.org.api.ResultData;

/**
 * @author liaochuntao
 */
public interface KafkaProducerService {

    /**
     * 将数据发送至kafka消息通道中
     * @param kafkaPackage
     * @return
     */
    ResultData sendDataToKafka(KafkaPackage kafkaPackage);

}
