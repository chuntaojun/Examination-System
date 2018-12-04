package com.tensor.org.dao.mapper.log;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liaochuntao
 */
@Repository
public interface ApiRequestPOMapper extends ReactiveMongoRepository<String, String> {
}
