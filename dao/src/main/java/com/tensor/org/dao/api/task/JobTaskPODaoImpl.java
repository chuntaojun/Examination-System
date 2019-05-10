package com.tensor.org.dao.api.task;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.job.JobEntityPO;
import com.tensor.org.api.dao.task.JobTaskPODao;
import com.tensor.org.dao.mapper.task.JobTaskPOMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liaochuntao
 */
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}",
        filter = "tracing")
public class JobTaskPODaoImpl implements JobTaskPODao {

    @Resource private JobTaskPOMapper jobTaskPOMapper;

    @Override
    public ResultData<JobEntityPO> createJob(JobEntityPO jobEntityPO) {
        return null;
    }

    @Override
    public ResultData<JobEntityPO> updateJob(JobEntityPO jobEntityPO) {
        return null;
    }

    @Override
    public ResultData cancleJob(String s) {
        return null;
    }

    @Override
    public ResultData<List<JobEntityPO>> allJobs(Page page) {
        return null;
    }
}
