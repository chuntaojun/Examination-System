package com.tensor.org.api.dao.enpity.job;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liaochuntao
 */
public class CompilerTaskPO implements Serializable {

    private static final long serialVersionUID = -6995164993835941605L;
    private long taskId;
    private String sourceName;
    private String sourceCode;
    private long startTime;
    private long endTime;
    private String taskOwnerId;
    private Object result;

    public CompilerTaskPO() {
    }

    public CompilerTaskPO(long taskId, String sourceName, String sourceCode, long startTime, long endTime, String taskOwnerId, Object result) {
        this.taskId = taskId;
        this.sourceName = sourceName;
        this.sourceCode = sourceCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.taskOwnerId = taskOwnerId;
        this.result = result;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getTaskOwnerId() {
        return taskOwnerId;
    }

    public void setTaskOwnerId(String taskOwnerId) {
        this.taskOwnerId = taskOwnerId;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CompilerTaskPO{" +
                "taskId=" + taskId +
                ", sourceName='" + sourceName + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", taskOwnerId='" + taskOwnerId + '\'' +
                ", result=" + result +
                '}';
    }
}
