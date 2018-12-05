package com.tensor.org.api.dao.task;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.job.JobEntityPO;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface JobTaskPODao {

    ResultData<JobEntityPO> createJob(JobEntityPO jobEntityPO);

    ResultData<JobEntityPO> updateJob(JobEntityPO jobEntityPO);

    ResultData cancleJob(String jobId);

    ResultData<List<JobEntityPO>> allJobs(Page page);

}
