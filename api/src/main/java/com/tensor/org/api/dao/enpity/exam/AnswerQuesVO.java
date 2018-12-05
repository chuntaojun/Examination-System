package com.tensor.org.api.dao.enpity.exam;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class AnswerQuesVO implements Serializable {

    private Integer id;

    private String quesDoc;

    private Float quesScore;

    private Date createTime;

    private Date updateTime;

    private String teacherNo;

    private static final long serialVersionUID = 6043948570425722611L;

    public AnswerQuesVO() {
    }

    public AnswerQuesVO(Integer id, String quesDoc, Float quesScore, Date createTime, Date updateTime, String teacherNo) {
        this.id = id;
        this.quesDoc = quesDoc;
        this.quesScore = quesScore;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.teacherNo = teacherNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuesDoc() {
        return quesDoc;
    }

    public void setQuesDoc(String quesDoc) {
        this.quesDoc = quesDoc;
    }

    public Float getQuesScore() {
        return quesScore;
    }

    public void setQuesScore(Float quesScore) {
        this.quesScore = quesScore;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    @Override
    public String toString() {
        return "AnswerQuesVO{" +
                "id=" + id +
                ", quesDoc='" + quesDoc + '\'' +
                ", quesScore=" + quesScore +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", teacherNo='" + teacherNo + '\'' +
                '}';
    }
}