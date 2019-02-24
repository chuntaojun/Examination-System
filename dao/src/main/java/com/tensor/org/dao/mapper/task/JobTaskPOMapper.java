package com.tensor.org.dao.mapper.task;

import com.tensor.org.api.dao.enpity.job.JobEntityPO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


/**
 * @author liaochuntao
 */
@Repository
public interface JobTaskPOMapper extends ReactiveMongoRepository<JobEntityPO, String> {

}
