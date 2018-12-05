package com.tensor.org.api.dao.enpity.exam;

import java.io.Serializable;

/**
 * 试题的包装类
 * @author liaochuntao
 */
public class QuestionPackage implements Serializable {

    private static final long serialVersionUID = 7171867550723188350L;
    /**
     * 操作类型
     */
    private int curdType;
    /**
     * 试题类型
     */
    private int quesType;
    /**
     * 试题的内容，对于选择题来说还包括了选项，
     * type：json
     */
    private String quesBody;

    public QuestionPackage() {
    }

    public QuestionPackage(int curdType, int quesType, String quesBody) {
        this.curdType = curdType;
        this.quesType = quesType;
        this.quesBody = quesBody;
    }

    public int getCurdType() {
        return curdType;
    }

    public int getQuesType() {
        return quesType;
    }

    public String getQuesBody() {
        return quesBody;
    }

    public static class Builder {

        private QuestionPackage questionPackage;

        public Builder() {
            questionPackage = new QuestionPackage();
        }

        public Builder curdType(int curdType) {
            questionPackage.curdType = curdType;
            return this;
        }

        public Builder quesType(int quesType) {
            questionPackage.quesType = quesType;
            return this;
        }

        public Builder quesBody(String quesBody) {
            questionPackage.quesBody = quesBody;
            return this;
        }

        public QuestionPackage builded() {
            return questionPackage;
        }

    }
}
