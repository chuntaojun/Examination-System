package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.notice.KafkaMsg;
import com.tensor.org.api.dao.enpity.notice.KafkaPackage;
import com.tensor.org.api.dao.enpity.notice.NoticePackage;
import com.tensor.org.api.dao.log.NoticeDao;
import com.tensor.org.api.user.NoticeService;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.work.service.kafka.KafkaProducer;
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

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}")
    private NoticeDao noticeDao;

    @Autowired private KafkaProducer kafkaProducer;

    /**
     * 所有通知入口
     * @param noticePackage
     * @return
     */
    @Override
    public ResultData publish(NoticePackage noticePackage) {
        ResultData<NoticePackage> resultData = noticeDao.save(noticePackage);
        if (resultData.getValue() != null) {
            kafkaProducer.producerMsg(KafkaPackage.builder()
                    .topic(kafkaTopicNotice)
                    .kafkaMsg(KafkaMsg.builder()
                            .id(UUID.randomUUID().toString())
                            .body(JsonUtils.toJson(noticePackage))
                            .sendTime(new Date())
                            .builded())
                    .builded());
            return new ResultData(HttpResponseStatus.OK.code(), null, "消息发布成功");
        }
        return ResultData.builder().code(HttpResponseStatus.BAD_REQUEST.code()).errMsg("消息发布失败").builded();
    }
}
