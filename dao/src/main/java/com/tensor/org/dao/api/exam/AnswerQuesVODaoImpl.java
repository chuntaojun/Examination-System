package com.tensor.org.dao.api.exam;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.AnswerQuesVO;
import com.tensor.org.api.dao.exam.AnswerQuesVODao;
import com.tensor.org.api.utils.CurdTypeEnum;
import com.tensor.org.dao.mapper.exam.AnswerQuesVOMapper;
import org.jboss.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class AnswerQuesVODaoImpl implements AnswerQuesVODao {

    @Resource private AnswerQuesVOMapper answerQuesVOMapper;

    @Override
    public ResultData<AnswerQuesVO> findAnswerQuesVOById(String s) {
        return null;
    }

    @Override
    public ResultData save(AnswerQuesVO answerQuesVO, int i) {
        int effectRow = 0;
        if (i == CurdTypeEnum.INSERT.getValue()) {
            effectRow = answerQuesVOMapper.save(answerQuesVO);
        }
        return ResultData.builder()
                .code(effectRow == 0 ? HttpResponseStatus.INTERNAL_SERVER_ERROR.getCode() : HttpResponseStatus.OK.getCode())
                .builded();
    }

    @Override
    public ResultData<List<AnswerQuesVO>> findAllAnswerQuesVO(Page page) {
        return null;
    }

    @Override
    public ResultData deleteQuesBatch(List<String> list) {
        return null;
    }
}
