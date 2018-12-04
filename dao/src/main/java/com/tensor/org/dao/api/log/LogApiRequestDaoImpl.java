package com.tensor.org.dao.api.log;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.log.ApiRequestDao;
import com.tensor.org.dao.mapper.log.ApiRequestPOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
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
        registry = "${dubbo.registry.id}")
public class LogApiRequestDaoImpl implements ApiRequestDao {

    @Resource private ApiRequestPOMapper apiRequestPOMapper;
    @Autowired private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public ResultData<String> save(String s) {
        return apiRequestPOMapper.save(s).map(s1 -> ResultData.builder().value(s1).builded()).block();
    }

    @Override
    public ResultData<List<String>> findAllApiRequestLog(Page page) {
        return null;
    }
}
