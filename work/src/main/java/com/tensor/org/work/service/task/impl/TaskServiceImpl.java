package com.tensor.org.work.service.task.impl;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.JobEntityPO;
import com.tensor.org.work.service.task.TaskService;
import com.tensor.org.work.service.task.job.PublishJob;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liaochuntao
 */
@Slf4j
@Service(value = "innerJobTaskService")
@Component
public class TaskServiceImpl implements TaskService {

    @Autowired private SchedulerFactoryBean schedulerFactoryBean;

    @Override
    public ResultData createJob(JobEntityPO jobEntityPO) {
        JobDetail jobDetail = JobBuilder.newJob(PublishJob.class)
                .withIdentity(JobKey.jobKey(jobEntityPO.getJobName(), jobEntityPO.getGroup()))
                .withDescription(jobEntityPO.getJobDesc())
                .storeDurably()
                .build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity(TriggerKey.triggerKey(jobEntityPO.getJobName(), jobEntityPO.getGroup()))
                .withSchedule(CronScheduleBuilder.cronSchedule(jobEntityPO.getJobCorn()))
                .build();
        try {
            schedulerFactoryBean.getScheduler().scheduleJob(jobDetail, trigger);
            return ResultData.builder().code(HttpResponseStatus.OK.code()).value(jobEntityPO.getJobCorn()).builded();
        } catch (SchedulerException e) {
            log.error("TaskServiceImpl SchedulerException : {}", e);
            return ResultData.builder().code(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()).errMsg(e.getMessage()).builded();
        }
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
