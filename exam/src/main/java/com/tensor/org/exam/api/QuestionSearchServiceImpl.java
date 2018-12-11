package com.tensor.org.exam.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.SearchConditionPO;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;
import com.tensor.org.api.exam.QuestionSearchService;
import com.tensor.org.exam.service.elastic.impl.ExamQuesSearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
public class QuestionSearchServiceImpl implements QuestionSearchService {

    @Autowired private ExamQuesSearchServiceImpl quesSearchService;

    @Override
    public ResultData save(QuestionPackage questionPackage) {
        return quesSearchService.save(questionPackage);
    }

    @Override
    public ResultData<List<QuestionPackage>> findQuesFuzz(SearchConditionPO searchConditionPO) {
        return quesSearchService.findQuesFuzzy(searchConditionPO);
    }
}
