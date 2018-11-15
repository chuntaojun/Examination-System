package com.tensor.org.work.service.socket;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author liaochuntao
 */
@Component
public class NoticePublishCenter {

    protected static ConcurrentHashMap<String, ConcurrentLinkedQueue> noticeCenterMap;

    static {
        noticeCenterMap = new ConcurrentHashMap<>();
    }

    public NoticePublishCenter() {}

    public void createNotice

}
