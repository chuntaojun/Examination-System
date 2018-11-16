package com.tensor.org.work.service.socket;

import java.util.Observer;

/**
 * @author liaochuntao
 */
public interface NoticeConsumerCenter extends Observer {

    void addReceiver(String receiver);

    void removeReceiver(String receiver);

}
