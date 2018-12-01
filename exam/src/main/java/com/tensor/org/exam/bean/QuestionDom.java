package com.tensor.org.exam.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author liaochuntao
 */
@Document(indexName = "dubbo-cloud-exam", type = "QuestionDom")
public class QuestionDom {

    @Id
    private String quesId;
    private String quesBody;
    private String quesAuthor;
    private Date quesCreate;

    public QuestionDom() {
    }

    public QuestionDom(String quesId, String quesBody, String quesAuthor, Date quesCreate) {
        this.quesId = quesId;
        this.quesBody = quesBody;
        this.quesAuthor = quesAuthor;
        this.quesCreate = quesCreate;
    }

    public String getQuesId() {
        return quesId;
    }

    public void setQuesId(String quesId) {
        this.quesId = quesId;
    }

    public String getQuesBody() {
        return quesBody;
    }

    public void setQuesBody(String quesBody) {
        this.quesBody = quesBody;
    }

    public String getQuesAuthor() {
        return quesAuthor;
    }

    public void setQuesAuthor(String quesAuthor) {
        this.quesAuthor = quesAuthor;
    }

    public Date getQuesCreate() {
        return quesCreate;
    }

    public void setQuesCreate(Date quesCreate) {
        this.quesCreate = quesCreate;
    }

    @Override
    public String toString() {
        return "QuestionDom{" +
                "quesId='" + quesId + '\'' +
                ", quesBody='" + quesBody + '\'' +
                ", quesAuthor='" + quesAuthor + '\'' +
                ", quesCreate=" + quesCreate +
                '}';
    }
}
