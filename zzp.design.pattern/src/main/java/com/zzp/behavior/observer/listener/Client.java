package com.zzp.behavior.observer.listener;

/**
 * @Description 客户端
 * @Author Garyzeng
 * @since 2020.07.30
 **/
public class Client {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();

        eventSource.addListener(new IntializingListener());
        eventSource.addListener(new IntializedListener());

        eventSource.fireEvent(new IntializingEvent(EventStateEnum.INTALIZING.getState(), "初始化事件"));
        eventSource.fireEvent(new IntializingEvent(EventStateEnum.INTALIZED.getState(), "初始化完成事件"));
    }

}
