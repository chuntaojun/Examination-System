package com.tensor.org.exam.service.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;

import java.util.List;

/**
 * @author liaochuntao
 */
public interface QuesService {

    ResultData save(QuestionPackage questionPackage);

    ResultData deleteBatch(List<QuestionPackage> var1);

    ResultData<QuestionPackage> findQuesCurd(QuestionPackage questionPackage);

    ResultData<List<QuestionPackage>> findAllQues(Page page, QuestionPackage questionPackage);

}
