package com.tensor.org.work.service.socket.impl;

import com.tensor.org.api.user.NoticePackage;
import com.tensor.org.work.service.socket.NoticeChannelHandler;
import com.tensor.org.work.service.socket.NoticeConsumerCenter;
import com.tensor.org.work.service.socket.NoticePublishCenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * 通知消费者中心，websocket channel从这里获取信息进行消费
 *
 * @author liaochuntao
 */
@Slf4j
@Component
public class NoticeConsumerCenterImpl extends Observable implements NoticeConsumerCenter {

    private static ConcurrentLinkedQueue<String> receivers = new ConcurrentLinkedQueue<>();

    @Autowired
    private NoticeChannelHandler noticeChannelHandler;
    @Autowired
    private NoticePublishCenter publishCenter;

    private static ThreadPoolExecutor PublishThreadPool;

    @PostConstruct
    private void init() {
        addObserver(publishCenter);
        PublishThreadPool = new ThreadPoolExecutor(4,
                12,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(20),
                new NoticeThreadFactory(),
                new RejectHandler());
    }

    /**
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        NoticePackage noticePackage = (NoticePackage) arg;
        PublishThreadPool.execute(new NoticeConsumeTask(noticePackage));
    }

    public static void addReceiver(String receiver) {
        if (!receivers.contains(receiver)) {
            receivers.add(receiver);
        }
        log.info("当前的 receivers : {}", receivers);
    }

    public static void removeReceiver(String receiver) {
        log.info("移除前的 receivers : {}", receivers);
        receivers.remove(receiver);
        log.info("移除后的 receivers : {}", receivers);
    }

    private class NoticeConsumeTask implements Runnable {

        private NoticePackage noticePackage;

        public NoticeConsumeTask(NoticePackage noticePackage) {
            this.noticePackage = noticePackage;
        }

        /**
         *
         */
        @Override
        public void run() {
            List<String> already = new ArrayList<>();
            noticePackage.getReceivers()
                    .parallelStream()
                    .filter(receiver -> receivers.contains(receiver))
                    .peek(receiver -> {
                        already.add(receiver);
                        noticeChannelHandler.publishMsg(noticePackage, receiver);
                    })
                    .count();
            noticePackage.getReceivers().removeAll(already);
            noticePackage.setTotalReceivers(noticePackage.getReceivers().size());
            setChanged();
            notifyObservers(noticePackage);
        }
    }

    /**
     * 线程池任务拒绝策略
     */
    private class RejectHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            log.error("{} 消息推送服务任务被拒绝。 {}", r.toString(), executor.toString());
        }
    }

    private class NoticeThreadFactory implements ThreadFactory {

        private final String namePrefix;
        private final AtomicInteger nextId = new AtomicInteger(1);

        NoticeThreadFactory() {
            namePrefix = "消息推送-工作线程-";
        }

        @Override
        public Thread newThread(Runnable r) {
            String name = namePrefix + nextId.getAndDecrement();
            return new Thread(r, name);
        }
    }

}
