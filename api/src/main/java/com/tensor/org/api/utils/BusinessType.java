package com.tensor.org.api.utils;

import com.tensor.org.api.utils.exception.NoSuchRoleTypeException;

/**
 * 业务类别
 * @author liaochuntao
 */
public final class BusinessType {

    /**
     * 试题类别枚举
     */
    public enum QuestionType {

        /**
         * 选择题
         */
        QUESTION_TYPE_SELECT(1, "select-question"),
        /**
         * 问答题
         */
        QUESTION_TYPE_ANSWERE(2, "answer-question"),
        /**
         * 判断题
         */
        QUESTION_TYPE_JUDGE(3, "judge-question");

        private int value;
        private String doc;

        QuestionType(int value, String doc) {
            this.value = value;
            this.doc = doc;
        }

        public int getValue() {
            return value;
        }

        public String getDoc() {
            return doc;
        }
    }

    public enum RoleType {
        /**
         *
         */
        ROLE_ADMIN(10, "ROLE_ADMIN"),

        /**
         *
         */
        ROLE_TEACHER(5, "ROLE_TEACHER"),

        /**
         *
         */
        ROLE_USER(1, "ROLE_USER");

        private int value;
        private String role;

        RoleType(int value, String role) {
            this.value = value;
            this.role = role;
        }

        public int getValue() {
            return value;
        }

        public String getRole() {
            return role;
        }

        public String getRoleName(int value) {
            if (value == ROLE_ADMIN.getValue()) {
                return ROLE_ADMIN.getRole();
            }
            if (value == ROLE_TEACHER.getValue()) {
                return ROLE_TEACHER.getRole();
            }
            if (value == ROLE_USER.getValue()) {
                return ROLE_USER.getRole();
            }
            throw new NoSuchRoleTypeException("There is no role for this value", "getRoleName", this.getClass());
        }

    }

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

}
