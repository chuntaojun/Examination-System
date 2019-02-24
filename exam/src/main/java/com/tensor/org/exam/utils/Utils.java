package com.tensor.org.exam.utils;

import com.tensor.org.api.dao.enpity.exam.AnswerQuesVO;
import com.tensor.org.api.dao.enpity.exam.JudgeQuesVO;
import com.tensor.org.api.dao.enpity.exam.SelectQuesVO;
import com.tensor.org.api.utils.BusinessType;
import com.tensor.org.api.utils.JsonUtils;
import com.tensor.org.exam.utils.exception.NoSuchQuesTypeException;

import java.time.LocalDate;
import java.util.Map;

/**
 * @author liaochuntao
 */
public class Utils {

    public static Object jsonToQues(int quesType, Map quesBody) {
        String s = JsonUtils.toJson(quesBody);
        if (BusinessType.QuestionType.QUESTION_TYPE_ANSWER.getValue() == quesType) {
            return (AnswerQuesVO) JsonUtils.toObj(s, AnswerQuesVO.class);
        }
        if (BusinessType.QuestionType.QUESTION_TYPE_JUDGE.getValue() == quesType) {
            return (JudgeQuesVO) JsonUtils.toObj(s, JudgeQuesVO.class);
        }
        if (BusinessType.QuestionType.QUESTION_TYPE_SELECT.getValue() == quesType) {
            return (SelectQuesVO) JsonUtils.toObj(s, SelectQuesVO.class);
        }
        throw new NoSuchQuesTypeException("ExamQuesSearchServiceImpl Err : " + "没有与之对应的试题类型");
    }

    public static String id() {
        LocalDate localDate = LocalDate.now();
        String s = String.valueOf(System.currentTimeMillis());
        return localDate.getYear() + localDate.getMonthValue() + localDate.getDayOfMonth() + s.substring(s.length() - 7);
    }

}
