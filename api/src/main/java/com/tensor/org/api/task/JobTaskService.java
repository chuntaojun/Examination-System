package com.tensor.org.api.task;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.JobEntityPO;

/**
 * @author liaochuntao
 */
public interface JobTaskService {

    ResultData createJob(JobEntityPO jobEntityPO);

}
