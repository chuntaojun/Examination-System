package com.tensor.org.api.dao.enpity.exam;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liaochuntao
 */
public class JudgeQuesVO implements Serializable {

    private static final long serialVersionUID = 621035499403899530L;
    private Integer id;

    private String quesDoc;

    private boolean quesChoice;

    private Float quesScore;

    private Date createTime;

    private Date updateTime;

    private String teacherNo;

    public JudgeQuesVO() {
    }

    public JudgeQuesVO(Integer id, String quesDoc, boolean quesChoice, Float quesScore, Date createTime, Date updateTime, String teacherNo) {
        this.id = id;
        this.quesDoc = quesDoc;
        this.quesChoice = quesChoice;
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

    public boolean isQuesChoice() {
        return quesChoice;
    }

    public void setQuesChoice(boolean quesChoice) {
        this.quesChoice = quesChoice;
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
        return "JudgeQuesVO{" +
                "id=" + id +
                ", quesDoc='" + quesDoc + '\'' +
                ", quesChoice=" + quesChoice +
                ", quesScore=" + quesScore +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", teacherNo='" + teacherNo + '\'' +
                '}';
    }
}
