package com.tensor.org.api.dao.enpity.job;

import lombok.Data;

@Data
public class JobEntity {

    private String jobId;
    private String jobCorn;
    private String jobName;
    private String jobDesc;
    private String jobCreateUser;
    private int jobStatus;

}
