package com.tensor.org.api.utils;

/**
 *
 */
public enum NoticeTopicEnum {
    KAFKA_TOPIC_EXAM_STU(0, "kafka-考试-试卷提交"),
    KAFKA_TOPIC_EXAM_QUES(1, "kafka-考试-试题");

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
