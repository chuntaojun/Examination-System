package com.tensor.org.api.dao.enpity.job;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liaochuntao
 */
@Data
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

}
