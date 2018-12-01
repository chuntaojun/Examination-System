package com.tensor.org.work.service.kafka.impl;

import com.tensor.org.api.kafka.KafkaMsg;
import com.tensor.org.api.kafka.KafkaPackage;
import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.work.service.kafka.KafkaConsumer;
import com.tensor.org.work.service.kafka.KafkaProducer;
import com.tensor.org.work.service.socket.NoticePublishCenter;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author liaochuntao
 */
@Slf4j
@Service
public class KafkaConsumerImpl implements KafkaConsumer {

    @Autowired private NoticePublishCenter noticePublishCenter;

    @KafkaListener(topics = {"kafka-topic-notice"})
    @Override
    public void receive(ConsumerRecord<String, String> record) {
        Optional<String> kafkaMsg = Optional.ofNullable(record.value());
        kafkaMsg.ifPresent(s -> {
            KafkaMsg msg = (KafkaMsg) JsonUtils.toObj(s, KafkaMsg.class);
            NoticePackage noticePackage = (NoticePackage) JsonUtils.toObj(msg.getBody(), NoticePackage.class);
            noticePublishCenter.createNoticeGroup(noticePackage);
        });
    }
}
