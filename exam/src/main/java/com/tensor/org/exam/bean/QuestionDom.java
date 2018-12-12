package com.tensor.org.exam.bean;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;
import java.util.Objects;

/**
 * @author liaochuntao
 */
@Builder
@Document(indexName = "dubbo-cloud-exam", type = "QuestionDom")
public class QuestionDom {

    @Id
    private String quesId;
    private String quesBody;
    private Date quesCreate;

    public static String SEARCH_FIELD_QUES_BODY = "quesBody";

    public QuestionDom() {}

    public QuestionDom(String quesId, String quesBody, Date quesCreate) {
        this.quesId = quesId;
        this.quesBody = quesBody;
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

    public Date getQuesCreate() {
        return quesCreate;
    }

    public void setQuesCreate(Date quesCreate) {
        this.quesCreate = quesCreate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuestionDom that = (QuestionDom) o;
        return Objects.equals(quesBody, that.quesBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quesBody);
    }

    @Override
    public String toString() {
        return "QuestionDom{" +
                "quesId='" + quesId + '\'' +
                ", quesBody='" + quesBody + '\'' +
                ", quesCreate=" + quesCreate +
                '}';
    }
}
