package com.tensor.org.api.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.Page;
import com.tensor.org.api.dao.enpity.exam.QuestionPackage;

import java.util.List;

/**
 * 试题管理中心
 * @author liaochuntao
 */
public interface QuestionManagerService {

    /**
     * 试题保存操作(添加、修改)
     * @param questionPackage {@link QuestionPackage}
     */
    ResultData saveQuesCurd(QuestionPackage questionPackage);

    /**
     * 批量删除试题信息
     * @param questionPackages
     * @return
     */
    ResultData deleteBatch(List<QuestionPackage> questionPackages);

    /**
     *
     * @param questionPackage
     * @return
     */
    ResultData<QuestionPackage> findQuesCurd(QuestionPackage questionPackage);

    /**
     *
     * @param page
     * @param questionPackage
     * @return
     */
    ResultData<List<QuestionPackage>> findAllQues(Page page, QuestionPackage questionPackage);

}
