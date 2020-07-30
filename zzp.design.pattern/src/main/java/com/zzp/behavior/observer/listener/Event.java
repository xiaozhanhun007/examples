package com.zzp.behavior.observer.listener;

/**
 * @Description 事件基础类
 * @Author Garyzeng
 * @since 2020.07.30
 **/
public class Event {

    private int state;

    private String name;

    public Event() {}

    public Event(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public String getName() {
        return name;
    }
}
