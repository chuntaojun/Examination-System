package com.tensor.org.api.kafka;

import com.tensor.org.api.ResultData;

/**
 * @author liaochuntao
 */
public interface KafkaConsumerService {

    /**
     * 从kafka消息通道中获取对应主题的消息信息
     * @param topic
     * @return
     */
    ResultData receiveDataFromKafka(String topic);

}
