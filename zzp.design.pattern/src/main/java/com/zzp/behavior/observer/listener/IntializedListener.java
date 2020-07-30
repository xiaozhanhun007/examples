package com.zzp.behavior.observer.listener;

/**
 * @Description 初始化完成事件监听器
 * @Author Garyzeng
 * @since 2020.07.30
 **/
public class IntializedListener implements Listener{

    public void eventHandler(Event e) {
        if (e != null && e.getState() == EventStateEnum.INTALIZED.getState()) {
            System.out.println("初始化完成监听器启动");
        }
    }
}
