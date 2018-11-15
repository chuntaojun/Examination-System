package com.tensor.org.work.utils;

import io.netty.channel.ChannelId;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liaochuntao
 */
public class ChannelIdManaeger {

    private static ConcurrentHashMap<String, ChannelId> channelIdMap;

    static {
        channelIdMap = new ConcurrentHashMap<>();
    }

    public static Optional<ChannelId> get(String key) {
        return Optional.ofNullable(channelIdMap.get(key));
    }

    public static void add(String key, ChannelId channelId) {
        channelIdMap.put(key, channelId);
    }

    public static void remove(String key) {
        channelIdMap.remove(key);
    }

    public static void remove(ChannelId channelId) {
        Iterator<Map.Entry<String, ChannelId>> iterator = channelIdMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, ChannelId> entry = iterator.next();
            if (entry.getValue().compareTo(channelId) == 0) {
                iterator.remove();
            }
        }
    }

}
