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
         *
         */
        QUESTION_SELECT_ID("QS"),
        QUESTION_ANSWER_ID("QA"),
        QUESTION_JUDGE_ID("QJ"),

        /**
         * 试题类型
         */
        QUESTION_TYPE_SELECT(1, "select-question"),
        QUESTION_TYPE_ANSWER(2, "answer-question"),
        QUESTION_TYPE_JUDGE(3, "judge-question");

        private int value;
        private String doc;

        QuestionType(String doc) {
            this.doc = doc;
        }

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

        public static String getRoleName(int value) {
            if (value == ROLE_ADMIN.getValue()) {
                return ROLE_ADMIN.getRole();
            }
            if (value == ROLE_TEACHER.getValue()) {
                return ROLE_TEACHER.getRole();
            }
            if (value == ROLE_USER.getValue()) {
                return ROLE_USER.getRole();
            }
            throw new NoSuchRoleTypeException("There is no role for this value", "getRoleName", RoleType.class);
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

    public enum SearchConditionType {
        /**
         * 试题查询
         */
        SEARCH_FOR_EXAM_QUESTION(1, "exam-question")
        ;
        private int val;
        private String type;

        SearchConditionType(int val, String type) {
            this.val = val;
            this.type = type;
        }

        public int getVal() {
            return val;
        }

        public String getType() {
            return type;
        }
    }

}
