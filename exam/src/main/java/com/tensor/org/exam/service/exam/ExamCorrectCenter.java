package com.tensor.org.exam.service.exam;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.notice.NoticePackage;

/**
 * @author liaochuntao
 */
public interface ExamCorrectCenter {

    ResultData publishWork(NoticePackage noticePackage);

}
