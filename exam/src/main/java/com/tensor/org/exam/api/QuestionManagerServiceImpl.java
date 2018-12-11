package com.tensor.org.exam.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;
import com.tensor.org.api.dao.enpity.notice.KafkaPackage;
import com.tensor.org.api.exam.QuestionManagerService;
import com.tensor.org.api.kafka.KafkaProducerService;
import com.tensor.org.exam.service.elastic.ExamQuesSearchService;
import com.tensor.org.exam.service.exam.QuesService;
import com.tensor.org.exam.utils.Utils;
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
public class QuestionManagerServiceImpl implements QuestionManagerService {

    @Autowired private QuesService quesService;
    @Autowired private ExamQuesSearchService examQuesSearchService;

    @Override
    public ResultData saveQuesCurd(QuestionPackage questionPackage) {
        questionPackage.setQuesId(Utils.id());
        examQuesSearchService.save(questionPackage);
        return quesService.save(questionPackage);
    }

    @Override
    public ResultData deleteBatch(List<QuestionPackage> questionPackages) {
        return quesService.deleteBatch(questionPackages);
    }

    @Override
    public ResultData<QuestionPackage> findQuesCurd(QuestionPackage questionPackage) {
        return quesService.findQuesCurd(questionPackage);
    }

    @Override
    public ResultData<List<QuestionPackage>> findAllQues(Page page, QuestionPackage questionPackage) {
        return quesService.findAllQues(page, questionPackage);
    }

}
