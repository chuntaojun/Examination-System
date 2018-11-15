package com.tensor.org.api.kafka;

import java.io.Serializable;

/**
 * kafka中对消息的包装，带上了主题topic信息
 * @author liaochuntao
 */
public class KafkaPackage implements Serializable {

    private static final long serialVersionUID = 8431505051653279635L;
    private String topic;
    private KafkaMsg kafkaMsg;

    public KafkaPackage() {
    }

    public KafkaPackage(String topic, KafkaMsg kafkaMsg) {
        this.topic = topic;
        this.kafkaMsg = kafkaMsg;
    }

    public String getTopic() {
        return topic;
    }

    public KafkaMsg getKafkaMsg() {
        return kafkaMsg;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private KafkaPackage kafkaPackage;

        public Builder() {
            kafkaPackage = new KafkaPackage();
        }

        public Builder topic(String topic) {
            kafkaPackage.topic = topic;
            return this;
        }

        public Builder kafkaMsg(KafkaMsg kafkaMsg) {
            kafkaPackage.kafkaMsg = kafkaMsg;
            return this;
        }

        public KafkaPackage builded() {
            return kafkaPackage;
        }

    }
}
