package com.zzp.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 主题
 * @Author Garyzeng
 * @since 2019.12.04
 **/
public class Subject {

    private List<Observer> observers = new ArrayList<Observer>();

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        // 出现变化，需要通知所有观察者
        notifyAllObservers();
    }

    public void addObserver(Observer observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }

    public void notifyAllObservers() {
        if (observers != null && observers.size() > 0) {
            for (int i = 0; i < observers.size(); i++) {
                observers.get(i).response();
            }
        }
    }

}
