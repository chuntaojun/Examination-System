package com.tensor.org.api.dao.enpity.job;

import lombok.Data;

/**
 * @author liaochuntao
 */
@Data
public class JobEntityPO {

    private String jobId;
    private String jobCorn;
    private String jobName;
    private String group;
    private String jobDesc;
    private String jobCreateUser;
    private int jobStatus;

}
