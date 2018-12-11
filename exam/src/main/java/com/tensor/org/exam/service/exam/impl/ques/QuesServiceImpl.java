package com.tensor.org.exam.service.exam.impl.ques;

import com.alibaba.dubbo.config.annotation.Reference;
import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.AnswerQuesVO;
import com.tensor.org.api.dao.enpity.exam.JudgeQuesVO;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;
import com.tensor.org.api.dao.enpity.exam.SelectQuesVO;
import com.tensor.org.api.dao.exam.AnswerQuesVODao;
import com.tensor.org.api.dao.exam.JudgeQuesVODao;
import com.tensor.org.api.dao.exam.SelectQuesVODao;
import com.tensor.org.api.utils.CurdTypeEnum;
import com.tensor.org.exam.service.exam.QuesService;
import com.tensor.org.exam.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Service
public class QuesServiceImpl implements QuesService {

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}")
    private AnswerQuesVODao answerQuesVODao;
    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}")
    private JudgeQuesVODao judgeQuesVODao;
    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}")
    private SelectQuesVODao selectQuesVODao;

    @Override
    public ResultData save(QuestionPackage questionPackage) {
        Object ques = Utils.jsonToQues(questionPackage.getQuesType(), questionPackage.getQuesBody());
        if (ques instanceof AnswerQuesVO) {
            return answerQuesVODao.save((AnswerQuesVO) ques, CurdTypeEnum.INSERT.getValue());
        }
        if (ques instanceof SelectQuesVO) {
            return selectQuesVODao.save((SelectQuesVO) ques, CurdTypeEnum.INSERT.getValue());
        }
        if (ques instanceof JudgeQuesVO) {
            return judgeQuesVODao.save((JudgeQuesVO) ques, CurdTypeEnum.INSERT.getValue());
        }
        return null;
    }

    @Override
    public ResultData deleteBatch(List<QuestionPackage> var1) {
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
