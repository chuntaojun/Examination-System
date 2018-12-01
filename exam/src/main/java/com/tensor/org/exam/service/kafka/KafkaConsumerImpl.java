package com.tensor.org.exam.service.kafka;

import com.tensor.org.api.kafka.KafkaMsg;
import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.exam.service.exam.ExamCorrectCenter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author liaochuntao
 */
@Slf4j
@Service
@Component
public class KafkaConsumerImpl implements KafkaConsumer {

    @Autowired private ExamCorrectCenter examCorrectCenter;

    @KafkaListener(topics = {"kafka-topic-notice"})
    public void receive(ConsumerRecord<String, String> record) {
        Optional<String> kafkaMsg = Optional.ofNullable(record.value());
        kafkaMsg.ifPresent(s -> {
            KafkaMsg msg = (KafkaMsg) JsonUtils.toObj(s, KafkaMsg.class);
            NoticePackage noticePackage = (NoticePackage) JsonUtils.toObj(msg.getBody(), NoticePackage.class);
            examCorrectCenter.publishWork(noticePackage);
        });
    }

}
