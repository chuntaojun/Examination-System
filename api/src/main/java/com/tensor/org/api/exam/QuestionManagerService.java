package com.tensor.org.api.exam;

import com.tensor.org.api.ResultData;

/**
 * 试题管理中心
 * @author liaochuntao
 */
public interface QuestionManagerService {

    /**
     *
     * @param questionPackage {@link QuestionPackage}
     */
    ResultData questionCurd(QuestionPackage questionPackage);

}
