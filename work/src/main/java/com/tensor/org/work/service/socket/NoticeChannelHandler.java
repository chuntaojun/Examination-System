package com.tensor.org.work.service.socket;

import com.tensor.org.api.dao.enpity.notice.NoticePackage;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liaochuntao
 */
public interface NoticeChannelHandler {

    Set<String> publishMsg(NoticePackage noticePackage, HashSet<String> receiver);

}
