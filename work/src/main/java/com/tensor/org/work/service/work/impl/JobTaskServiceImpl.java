package com.tensor.org.work.service.work.impl;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.JobEntity;
import com.tensor.org.work.service.work.JobTaskService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Component
public class JobTaskServiceImpl implements JobTaskService {

    @Override
    public ResultData createJob(JobEntity jobEntity) {
        JobDataMap jobDataMap = new JobDataMap();
        return null;
    }

    @Override
    public ResultData runJob() {
        return null;
    }

    @Override
    public ResultData cancleJob() {
        return null;
    }

    @Override
    public ResultData<List> allJobs() {
        return null;
    }

}
