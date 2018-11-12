package com.tensor.org.api.exam;

/**
 * 试题的包装类
 * @author liaochuntao
 */
public class QuestionPackage {

    /**
     * 试题类型
     */
    private int curdType;
    /**
     * 试题的内容，对于选择题来说还包括了选项，
     * type：json
     */
    private String quesBody;

    public QuestionPackage() {
    }

    public QuestionPackage(int curdType, String quesBody) {
        this.curdType = curdType;
        this.quesBody = quesBody;
    }

    public int getCurdType() {
        return curdType;
    }

    public String getQuesBody() {
        return quesBody;
    }

    public static class Builder {

    }
}
