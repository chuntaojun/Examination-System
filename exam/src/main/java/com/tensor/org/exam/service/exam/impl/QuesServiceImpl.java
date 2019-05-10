package com.tensor.org.exam.service.exam.impl;

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
import com.tensor.org.exam.service.elastic.ExamQuesSearchService;
import com.tensor.org.exam.service.exam.QuesService;
import com.tensor.org.exam.utils.Utils;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.tensor.org.api.utils.BusinessType.QuestionType.QUESTION_ANSWER_ID;
import static com.tensor.org.api.utils.BusinessType.QuestionType.QUESTION_JUDGE_ID;
import static com.tensor.org.api.utils.BusinessType.QuestionType.QUESTION_SELECT_ID;

/**
 * @author liaochuntao
 */
@Slf4j
@Component
@Service
public class QuesServiceImpl implements QuesService {

    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}", timeout = 5000)
    private AnswerQuesVODao answerQuesVODao;
    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}")
    private JudgeQuesVODao judgeQuesVODao;
    @Reference(version = "1.0.0", application = "${dubbo.application.id}", url = "${dubbo.provider.url.dao}")
    private SelectQuesVODao selectQuesVODao;

    @Autowired private ExamQuesSearchService quesSearchService;

    @Override
    public ResultData save(QuestionPackage questionPackage) {
        log.info("QuestionPackage : {}", questionPackage);
        ResultData resultData = null;
        Object ques = Utils.jsonToQues(questionPackage.getQuesType(), questionPackage.getQuesBody());
        if (ques instanceof AnswerQuesVO) {
            ((AnswerQuesVO) ques).setId(QUESTION_ANSWER_ID.getDoc() + Utils.id());
            questionPackage.setQuesId(((AnswerQuesVO) ques).getId());
            resultData = answerQuesVODao.save((AnswerQuesVO) ques, CurdTypeEnum.INSERT.getValue());
        }
        else if (ques instanceof SelectQuesVO) {
            ((SelectQuesVO) ques).setId(QUESTION_SELECT_ID.getDoc() + Utils.id());
            questionPackage.setQuesId(((SelectQuesVO) ques).getId());
            resultData = selectQuesVODao.save((SelectQuesVO) ques, CurdTypeEnum.INSERT.getValue());
        }
        else if (ques instanceof JudgeQuesVO) {
            ((JudgeQuesVO) ques).setId(QUESTION_JUDGE_ID.getDoc() + Utils.id());
            questionPackage.setQuesId(((JudgeQuesVO) ques).getId());
            resultData = judgeQuesVODao.save((JudgeQuesVO) ques, CurdTypeEnum.INSERT.getValue());
        }
        if (resultData.getCode() == HttpResponseStatus.OK.code()) {
            quesSearchService.save(questionPackage);
        }
        return resultData;
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
