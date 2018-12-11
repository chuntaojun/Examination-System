package com.tensor.org.exam.service.elastic;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.SearchConditionPO;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface ExamQuesSearchService {

    ResultData save(QuestionPackage questionPackage);

    ResultData<List<QuestionPackage>> findQuesFuzzy(SearchConditionPO searchConditionPO);

}
