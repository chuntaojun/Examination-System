package com.tensor.org.work.service.socket;

import com.tensor.org.work.service.socket.impl.NoticeConsumerCenterImpl;
import io.netty.channel.ChannelId;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liaochuntao
 */
public class ChannelIdPool {

    private static ConcurrentHashMap<String, ChannelId> channelIdMap;

    static {
        channelIdMap = new ConcurrentHashMap<>();
    }

    public ChannelIdPool() {}

    public static Optional<ChannelId> get(String key) {
        return Optional.ofNullable(channelIdMap.get(key));
    }

    /**
     *
     * @param key
     * @param channelId
     */
    public static void add(String key, ChannelId channelId) {
        channelIdMap.put(key, channelId);
    }

    /**
     *
     * @param key
     */
    public static void remove(String key) {
        channelIdMap.remove(key);
    }

    /**
     *
     * @param channelId
     */
    public static void remove(ChannelId channelId) {
        Iterator<Map.Entry<String, ChannelId>> iterator = channelIdMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ChannelId> entry = iterator.next();
            if (entry.getValue().compareTo(channelId) == 0) {
                iterator.remove();
                NoticeConsumerCenterImpl.removeReceiver(entry.getKey());
            }
        }
    }

}
