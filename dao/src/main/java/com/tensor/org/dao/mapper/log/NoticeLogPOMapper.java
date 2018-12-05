package com.tensor.org.dao.mapper.log;

import com.tensor.org.api.dao.enpity.notice.NoticePackage;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liaochuntao
 */
@Repository
public interface NoticeLogPOMapper extends ReactiveMongoRepository<NoticePackage, String> {

}
