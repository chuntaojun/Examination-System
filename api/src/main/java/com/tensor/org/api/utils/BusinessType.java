package com.tensor.org.api.utils;

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

}
