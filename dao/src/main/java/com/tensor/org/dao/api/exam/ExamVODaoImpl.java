package com.tensor.org.dao.api.exam;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.ExamVO;
import com.tensor.org.api.dao.exam.ExamVODao;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liaochuntao
 */
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class ExamVODaoImpl implements ExamVODao {

    @Override
    public ResultData<ExamVO> findExamById(String s) {
        return null;
    }

    @Override
    public ResultData save(ExamVO examVO, int i) {
        return null;
    }

    @Override
    public ResultData<List<ExamVO>> findAllExamVO(Page page) {
        return null;
    }
}
