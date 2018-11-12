package com.tensor.org.api.kafka;

import java.util.Date;

/**
 * kafka消息通道中消息存储格式
 * @author liaochuntao
 */
public class KafkaMsg {

    private String id;
    private String body;
    private Date sendTime;

    public KafkaMsg() {
    }

    public KafkaMsg(String id, String body, Date sendTime) {
        this.id = id;
        this.body = body;
        this.sendTime = sendTime;
    }

    public String getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public static class Builder {

        private KafkaMsg kafkaMsg;

        public Builder() {
            kafkaMsg = new KafkaMsg();
        }

        public Builder id(String id) {
            kafkaMsg.id = id;
            return this;
        }

        public Builder body(String body) {
            kafkaMsg.body = body;
            return this;
        }

        public Builder sendTime(Date sendTime) {
            kafkaMsg.sendTime = sendTime;
            return this;
        }

        public KafkaMsg builded() {
            return kafkaMsg;
        }
    }
}
