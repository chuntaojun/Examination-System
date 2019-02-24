package com.tensor.org.dao.api.exam;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.SelectQuesVO;
import com.tensor.org.api.dao.exam.SelectQuesVODao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class SelectQuesVODaoImpl implements SelectQuesVODao {
    @Override
    public ResultData<SelectQuesVO> findSelectQuesVOById(String s) {
        return null;
    }

    @Override
    public ResultData save(SelectQuesVO selectQuesVO, int i) {
        return null;
    }

    @Override
    public ResultData<List<SelectQuesVO>> findAllSelectQues(Page page) {
        return null;
    }

    @Override
    public ResultData deleteQuesBatch(List<String> list) {
        return null;
    }
}
