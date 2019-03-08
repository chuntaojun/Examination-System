package com.tensor.org.work.service.socket;

import io.netty.util.AttributeKey;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author liaochuntao
 */
public final class ClientChannelAttrManage {

    private ClientChannelAttrManage() {}

    public static final AttributeKey<String> CLIENT_ID_ATTRIBUTEKEY = AttributeKey.valueOf("CLIENT_ID");

}
