package com.zzp.behavior.observer.listener;

/**
 * @Description 事件枚举
 * @Author Garyzeng
 * @since 2020.07.30
 **/
public enum EventStateEnum {
    
    INTALIZING(1),
    INTALIZED(2);

    private int state;

    private EventStateEnum(int state) {
        this.state = state;
    }

    public int getState() {
        return state;
    }
}
