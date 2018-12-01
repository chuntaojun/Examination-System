package com.tensor.org.exam.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.exam.QuestionManagerService;
import com.tensor.org.api.exam.QuestionPackage;
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
public class QuestionManagerServiceImpl implements QuestionManagerService {

    @Override
    public ResultData saveQuesCurd(QuestionPackage questionPackage) {
        return null;
    }

    @Override
    public ResultData deleteBatch(List<QuestionPackage> questionPackages) {
        return null;
    }

    @Override
    public ResultData<QuestionPackage> findQuesCurd(QuestionPackage questionPackage) {
        return null;
    }

    @Override
    public ResultData<List<QuestionPackage>> findAllQues(Page page, QuestionPackage questionPackage) {
        return null;
    }
}
