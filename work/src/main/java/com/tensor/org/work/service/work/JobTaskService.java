package com.tensor.org.work.service.work;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.JobEntity;

import java.util.List;

public interface JobTaskService {

    ResultData createJob(JobEntity jobEntity);

    ResultData runJob();

    ResultData cancleJob();

    ResultData<List> allJobs();

}
