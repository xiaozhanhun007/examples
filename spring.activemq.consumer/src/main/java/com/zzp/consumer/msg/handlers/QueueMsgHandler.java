package com.zzp.consumer.msg.handlers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Description 消息队列处理handler
 * @Author Garyzeng
 * @since 2019.12.03
 **/
@Component
public class QueueMsgHandler {

    @JmsListener(destination = "test_queue")
    public void receiveMessage(String msg) {
        System.out.println(msg);
    }

}
