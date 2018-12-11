package com.tensor.org.api.dao.enpity.exam;

import java.io.Serializable;
import java.util.Map;

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
     * 试题编号
     */
    private String quesId;
    /**
     * 试题的内容，对于选择题来说还包括了选项，
     * type：json
     */
    private Map quesBody;

    public QuestionPackage() {
    }

    public QuestionPackage(int curdType, int quesType, Map quesBody) {
        this.curdType = curdType;
        this.quesType = quesType;
        this.quesBody = quesBody;
    }

    public int getCurdType() {
        return curdType;
    }

    public void setCurdType(int curdType) {
        this.curdType = curdType;
    }

    public int getQuesType() {
        return quesType;
    }

    public void setQuesType(int quesType) {
        this.quesType = quesType;
    }

    public String getQuesId() {
        return quesId;
    }

    public void setQuesId(String quesId) {
        this.quesId = quesId;
    }

    public Map getQuesBody() {
        return quesBody;
    }

    public void Map(Map quesBody) {
        this.quesBody = quesBody;
    }

    public static Builder builder() {
        return new Builder();
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

        public Builder quesId(String quesId) {
            questionPackage.quesId = quesId;
            return this;
        }

        public Builder quesType(int quesType) {
            questionPackage.quesType = quesType;
            return this;
        }

        public Builder quesBody(Map quesBody) {
            questionPackage.quesBody = quesBody;
            return this;
        }

        public QuestionPackage builded() {
            return questionPackage;
        }

    }

    @Override
    public String toString() {
        return "QuestionPackage{" +
                "curdType=" + curdType +
                ", quesType=" + quesType +
                ", quesId='" + quesId + '\'' +
                ", quesBody=" + quesBody +
                '}';
    }
}
