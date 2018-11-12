package com.tensor.org.api.utils;

/**
 * 消息Topic
 * @author liaochuntao
 */
public enum NoticeTopicEnum {
    /**
     * Kafka——试卷提交事件消息
     */
    KAFKA_TOPIC_EXAM_STU_HAND(0, "kafka-exam-hand"),
    /**
     * Kafka——试题录入事件
     */
    KAFKA_TOPIC_EXAM_QUES(1, "kafka-exam-question");

    private int value;
    private String topicName;

    NoticeTopicEnum(int value, String topicName) {
        this.value = value;
        this.topicName = topicName;
    }

    public int getValue() {
        return value;
    }

    public String getTopicName() {
        return topicName;
    }
}
