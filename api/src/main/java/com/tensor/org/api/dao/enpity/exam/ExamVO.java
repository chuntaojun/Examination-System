package com.tensor.org.api.dao.enpity.exam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author 
 */
public class ExamVO implements Serializable {

    private static final long serialVersionUID = 5768159524272272476L;

    private String examId;

    private String orgId;

    private Date createTime;

    private Date publishTime;

    private Date deadLine;

    private Integer examDuration;

    private Integer status;

    private List<SelectQuesVO> selectQuesVOS;

    private List<AnswerQuesVO> answerQuesVOS;

    public ExamVO() {
    }

    public ExamVO(String examId, String orgId, Date createTime, Date publishTime, Date deadLine, Integer examDuration, Integer status, List<SelectQuesVO> selectQuesVOS, List<AnswerQuesVO> answerQuesVOS) {
        this.examId = examId;
        this.orgId = orgId;
        this.createTime = createTime;
        this.publishTime = publishTime;
        this.deadLine = deadLine;
        this.examDuration = examDuration;
        this.status = status;
        this.selectQuesVOS = selectQuesVOS;
        this.answerQuesVOS = answerQuesVOS;
    }

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(Date deadLine) {
        this.deadLine = deadLine;
    }

    public Integer getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(Integer examDuration) {
        this.examDuration = examDuration;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<SelectQuesVO> getSelectQuesVOS() {
        return selectQuesVOS;
    }

    public void setSelectQuesVOS(List<SelectQuesVO> selectQuesVOS) {
        this.selectQuesVOS = selectQuesVOS;
    }

    public List<AnswerQuesVO> getAnswerQuesVOS() {
        return answerQuesVOS;
    }

    public void setAnswerQuesVOS(List<AnswerQuesVO> answerQuesVOS) {
        this.answerQuesVOS = answerQuesVOS;
    }

    @Override
    public String toString() {
        return "ExamVO{" +
                "examId='" + examId + '\'' +
                ", orgId='" + orgId + '\'' +
                ", createTime=" + createTime +
                ", publishTime=" + publishTime +
                ", deadLine=" + deadLine +
                ", examDuration=" + examDuration +
                ", status=" + status +
                ", selectQuesVOS=" + selectQuesVOS +
                ", answerQuesVOS=" + answerQuesVOS +
                '}';
    }
}