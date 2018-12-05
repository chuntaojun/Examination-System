package com.tensor.org.api.user;

import com.tensor.org.api.ResultData;
import com.tensor.org.api.dao.enpity.notice.NoticePackage;

/**
 * 通知中心
 * @author liaochuntao
 */
public interface NoticeService {

    /**
     *
     * @param noticePackage
     */
    ResultData publish(NoticePackage noticePackage);

}
