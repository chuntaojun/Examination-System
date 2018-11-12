package com.tensor.org.api.utils;

/**
 * 业务状态类，所有的业务状态信息
 */
public final class BusinessState {

    /**
     * 试卷有关状态信息
     */
    public enum ExamStateEnum {

        /**
         * 试卷发布状态
         */
        EXAM_HAD_PUBLISH(10, "试卷已发布"),

        /**
         * 试卷待发布钻塔
         */
        EXAM_WAIT_PUBLISH(9, "试卷待发布");

        private int value;
        private String doc;

        ExamStateEnum(int value, String doc) {
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

}
