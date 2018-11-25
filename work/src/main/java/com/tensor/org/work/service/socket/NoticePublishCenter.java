package com.tensor.org.work.service.socket;

import com.tensor.org.api.user.NoticePackage;

import java.util.Observer;

/**
 * @author liaochuntao
 */
public interface NoticePublishCenter extends Observer {

    /**
     * 创建消息通知主题并放入消息信息
     * @param noticePackage
     * @return
     */
    boolean createNoticeGroup(NoticePackage noticePackage);

}
