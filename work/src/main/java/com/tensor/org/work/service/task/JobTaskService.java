package com.tensor.org.work.service.task;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.JobEntityPO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface JobTaskService {

    ResultData createJob(JobEntityPO jobEntityPO);

    ResultData runJob();

    ResultData cancleJob();

    ResultData<List> allJobs();

}
