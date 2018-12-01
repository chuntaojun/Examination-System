package com.tensor.org.dao.api.exam;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.dao.exam.ExamScoreVODao;
import org.springframework.stereotype.Component;

/**
 * @author liaochuntao
 */
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class ExamScoreVODaoImpl implements ExamScoreVODao {
}
