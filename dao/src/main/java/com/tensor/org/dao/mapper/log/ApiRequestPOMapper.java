package com.tensor.org.dao.mapper.log;

import com.tensor.org.api.dao.enpity.log.LogApiRequestPO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liaochuntao
 */
@Repository
public interface ApiRequestPOMapper extends ReactiveMongoRepository<LogApiRequestPO, String> {
}
