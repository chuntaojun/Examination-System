package com.tensor.org.work.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.job.JobEntityPO;
import com.tensor.org.api.task.JobTaskService;
import lombok.extern.slf4j.Slf4j;
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

    @Override
    public ResultData createJob(JobEntityPO jobEntityPO) {
        return null;
    }
}
