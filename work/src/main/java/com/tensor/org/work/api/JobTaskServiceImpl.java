package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.JobEntityPO;
import com.tensor.org.api.task.JobTaskService;
import com.tensor.org.work.service.task.TaskService;
import com.tensor.org.work.utils.CronExpressUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class JobTaskServiceImpl implements JobTaskService {

    @Autowired private TaskService jobTaskService;

    @Override
    public ResultData createJob(JobEntityPO jobEntityPO) {
        log.info("date : {}", jobEntityPO.getJobExecute());
        jobEntityPO.setJobCorn(CronExpressUtils.date2CornExpress(jobEntityPO.getJobExecute()));
        return jobTaskService.createJob(jobEntityPO);
    }
}
