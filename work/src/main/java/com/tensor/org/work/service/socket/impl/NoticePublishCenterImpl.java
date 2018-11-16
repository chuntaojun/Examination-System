package com.tensor.org.work.service.socket.impl;

import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.work.service.socket.NoticeConsumerCenter;
import com.tensor.org.work.service.socket.NoticePublishCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 通知发布者中心
 *
 * @author liaochuntao
 */
@Component
public class NoticePublishCenterImpl extends Observable implements NoticePublishCenter {

    private static final Object lock = new Object();

    @Autowired private NoticeConsumerCenter noticeConsumerCenter;

    protected static ConcurrentHashMap<String, NoticePackage> noticeCenterMap;

    static {
        noticeCenterMap = new ConcurrentHashMap<>();
    }

    public NoticePublishCenterImpl() {}

    @PostConstruct
    public void init() {
        addObserver(noticeConsumerCenter);
    }

    @Override
    public boolean createNoticeGroup(String groupName, NoticePackage noticePackage) {
        if (noticeCenterMap.containsKey(groupName)) {
            noticeCenterMap.put(groupName, noticePackage);
            notifyObservers(groupName);
            return true;
        }
        return false;
    }

    public static void finishNotice(String groupName) {
        synchronized (lock) {
            noticeCenterMap.remove(groupName);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        NoticePackage noticePackage = (NoticePackage) arg;
        if (noticePackage.getTotalReceivers() == 0) {
            finishNotice(noticePackage.getNoticeLabel());
        } else {
            noticeCenterMap.put(noticePackage.getNoticeLabel(), noticePackage);
        }
    }
}
