package com.tensor.org.api.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.SearchConditionPO;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;

import java.util.List;

/**
 * 试题搜索服务
 * @author liaochuntao
 */
public interface QuestionSearchService {

    /**
     *
     * @param questionPackage
     * @return
     */
    ResultData save(QuestionPackage questionPackage);

    /**
     *
     * @param searchConditionPO
     * @return
     */
    ResultData<List<QuestionPackage>> findQuesFuzz(SearchConditionPO searchConditionPO);

}
