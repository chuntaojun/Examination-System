package com.tensor.org.work.service.socket.impl;

import com.tensor.org.api.dao.log.NoticeDao;
import com.tensor.org.api.dao.enpity.notice.KafkaMsg;
import com.tensor.org.api.dao.enpity.notice.KafkaPackage;
import com.tensor.org.api.dao.enpity.notice.NoticePackage;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.work.service.kafka.KafkaProducer;
import com.tensor.org.work.service.socket.NoticeConsumerCenter;
import com.tensor.org.work.service.socket.NoticePublishCenter;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Observable;
import java.util.UUID;

/**
 * 通知发布者中心，发布的消息进入此处准备发送
 * @// FIXME: 2018/12/1 修复多线程消费消息导致客户端消息漏收bug
 * @author liaochuntao
 */
@Slf4j
@Component
public class NoticePublishCenterImpl extends Observable implements NoticePublishCenter {

    @Value("${kafka.consumer.topic.notice}")
    private String kafkaTopicNotice;

    @Reference(version = "1.0.0", application = "${dubbo.application.id}")
    private NoticeDao noticeDao;

    @Autowired
    private NoticeConsumerCenter noticeConsumerCenter;
    @Qualifier("KafkaProducer")
    @Autowired
    private KafkaProducer kafkaProducer;

    @PostConstruct
    public void init() {
        addObserver(noticeConsumerCenter);
    }

    @Override
    public boolean createNoticeGroup(NoticePackage noticePackage) {
        setChanged();
        notifyObservers(noticePackage);
        return true;
    }

    /**
     * 由消息消费者中心通知回调告知通知发布中心该消息消费结果
     * 如果消息通知任务未完成，则消息发布中心将消息回压至kafka消息队列
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        NoticePackage noticePackage = (NoticePackage) arg;
        if (noticePackage.getTotalReceivers() == 0) {
            noticePackage.setFinish(true);
            noticeDao.updateStatus(noticePackage);
        } else {
            KafkaMsg kafkaMsg = KafkaMsg.builder()
                    .id(UUID.randomUUID().toString())
                    .body(JsonUtils.toJson(noticePackage))
                    .sendTime(new Date())
                    .builded();
            kafkaProducer.producerMsg(KafkaPackage.builder().topic(kafkaTopicNotice).kafkaMsg(kafkaMsg).builded());
        }
    }

}
