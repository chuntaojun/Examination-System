package com.tensor.org.work.service.socket;

import com.tensor.org.api.user.NoticePackage;

/**
 * @author liaochuntao
 */
public interface NoticeChannelHandler {

    void publishMsg(NoticePackage noticePackage, String receiver);

}
