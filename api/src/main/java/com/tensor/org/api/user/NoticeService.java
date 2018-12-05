package com.tensor.org.api.user;

import com.tensor.org.api.ResultData;

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
