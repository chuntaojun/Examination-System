package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.kafka.KafkaMsg;
import com.tensor.org.api.kafka.KafkaPackage;
import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.api.user.NoticeService;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.work.service.kafka.KafkaProducer;
import com.tensor.org.work.service.socket.impl.NoticeChannelHandlerImpl;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * 消息发布接口
 *
 * @author liaochuntao
 */
@Slf4j
@Component
@Service(version = "1.0.0",
         application = "${dubbo.application.id}",
         protocol = "${dubbo.protocol.id}",
         registry = "${dubbo.registry.id}")
public class NoticePublishServiceImpl implements NoticeService {

    @Value("${kafka.consumer.topic.notice}") private String kafkaTopicNotice;

    @Autowired private KafkaProducer kafkaProducer;

    @Override
    public ResultData publish(NoticePackage noticePackage) {
        kafkaProducer.producerMsg(KafkaPackage.builder()
                .topic(kafkaTopicNotice)
                .kafkaMsg(KafkaMsg.builder()
                        .id(UUID.randomUUID().toString())
                        .body(JsonUtils.toJson(noticePackage))
                        .sendTime(new Date())
                        .builded())
                .builded());
        return ResultData.builder().builded();
    }
}
