package com.tensor.org.api.dao.enpity.job;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liaochuntao
 */
public class JobEntityPO implements Serializable {

    private static final long serialVersionUID = -8230074001350521508L;
    private String jobId;
    private Date jobExecute;
    private String jobCorn;
    private String jobName;
    private String group;
    private String jobDesc;
    private String jobCreateUser;
    private Date jobCreateDate;
    private int jobStatus;

    public JobEntityPO() {
    }

    public JobEntityPO(String jobId, Date jobExecute, String jobCorn, String jobName, String group, String jobDesc, String jobCreateUser, Date jobCreateDate, int jobStatus) {
        this.jobId = jobId;
        this.jobExecute = jobExecute;
        this.jobCorn = jobCorn;
        this.jobName = jobName;
        this.group = group;
        this.jobDesc = jobDesc;
        this.jobCreateUser = jobCreateUser;
        this.jobCreateDate = jobCreateDate;
        this.jobStatus = jobStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public Date getJobExecute() {
        return jobExecute;
    }

    public void setJobExecute(Date jobExecute) {
        this.jobExecute = jobExecute;
    }

    public String getJobCorn() {
        return jobCorn;
    }

    public void setJobCorn(String jobCorn) {
        this.jobCorn = jobCorn;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobCreateUser() {
        return jobCreateUser;
    }

    public void setJobCreateUser(String jobCreateUser) {
        this.jobCreateUser = jobCreateUser;
    }

    public Date getJobCreateDate() {
        return jobCreateDate;
    }

    public void setJobCreateDate(Date jobCreateDate) {
        this.jobCreateDate = jobCreateDate;
    }

    public int getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(int jobStatus) {
        this.jobStatus = jobStatus;
    }

    @Override
    public String toString() {
        return "JobEntityPO{" +
                "jobId='" + jobId + '\'' +
                ", jobExecute=" + jobExecute +
                ", jobCorn='" + jobCorn + '\'' +
                ", jobName='" + jobName + '\'' +
                ", group='" + group + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                ", jobCreateUser='" + jobCreateUser + '\'' +
                ", jobCreateDate=" + jobCreateDate +
                ", jobStatus=" + jobStatus +
                '}';
    }
}
