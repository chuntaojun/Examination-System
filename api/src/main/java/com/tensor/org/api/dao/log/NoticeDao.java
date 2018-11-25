package com.tensor.org.api.dao.log;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.user.NoticePackage;

/**
 * @author liaochuntao
 */
public interface NoticeDao {

    ResultData<?> save(NoticePackage noticePackage);

    ResultData<NoticePackage> findNoticeById(String id);

}
