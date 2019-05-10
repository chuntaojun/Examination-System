package com.tensor.org.dao.api.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.JudgeQuesVO;
import com.tensor.org.api.dao.exam.AnswerQuesVODao;
import com.tensor.org.api.dao.exam.JudgeQuesVODao;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

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
public class JudgeQuesVODaoImpl implements JudgeQuesVODao {

    @Override
    public ResultData<AnswerQuesVODao> findJudgeQuesVOById(String quesId) {
        return null;
    }

    @Override
    public ResultData save(JudgeQuesVO judgeQuesVO, int curdType) {
        return null;
    }

    @Override
    public ResultData<List<JudgeQuesVO>> findAllJudgeQuesVO(Page page) {
        return null;
    }

    @Override
    public ResultData deleteQuesBatch(List<String> quesIds) {
        return null;
    }
}
