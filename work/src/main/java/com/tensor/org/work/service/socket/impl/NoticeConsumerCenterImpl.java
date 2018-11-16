package com.tensor.org.work.service.socket.impl;

import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.work.service.socket.NoticeChannelHandler;
import com.tensor.org.work.service.socket.NoticeConsumerCenter;
import com.tensor.org.work.service.socket.NoticePublishCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 通知消费者中心
 * @author liaochuntao
 */
@Component
public class NoticeConsumerCenterImpl extends Observable implements NoticeConsumerCenter {

    private static ConcurrentLinkedQueue<String> receivers = new ConcurrentLinkedQueue<>();

    @Autowired private NoticeChannelHandler noticeChannelHandler;
    @Autowired private NoticePublishCenter publishCenter;

    @Override
    public void update(Observable o, Object arg) {

    }

    private class NoticeCallable implements Callable {

        private NoticePackage noticePackage;
        private String receiverId;

        public NoticeCallable(NoticePackage noticePackage) {
            this.noticePackage = noticePackage;
        }

        @Override
        public Object call() throws Exception {
            noticeChannelHandler.publishMsg(noticePackage);
            return null;
        }
    }

    @Override
    public void addReceiver(String receiver) {
        if (!receivers.contains(receiver)) {
            receivers.add(receiver);
        }
    }

    @Override
    public void removeReceiver(String receiver) {
        receivers.remove(receiver);
    }
}
