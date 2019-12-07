package com.zzp.consumer.msg.handlers;

/**
 * @Description handler接口
 * @Author Garyzeng
 * @since 2019.12.07
 **/
public interface BaseHandler {

    /**
     * 判断是否有能力处理该消息
     * @param msg 消息字符串
     * @return
     */
    boolean hasHandle(String msg);

    /**
     * 处理消息
     * @param msg 消息字符串
     */
    void handler(String msg);

}
