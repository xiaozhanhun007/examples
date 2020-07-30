package com.zzp.behavior.observer.listener;

/**
 * @Description 初始化事件监听器
 * @Author Garyzeng
 * @since 2020.07.30
 **/
public class IntializingListener implements Listener{

    public void eventHandler(Event e) {
        if (e != null && e.getState() == EventStateEnum.INTALIZING.getState()) {
            System.out.println("初始化监听器启动");
        }
    }
}
