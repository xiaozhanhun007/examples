package com.zzp.behavior.observer;

/**
 * @Description 观察者
 * @Author Garyzeng
 * @since 2019.12.04
 **/
public abstract class Observer {

    protected Subject subject;

    public abstract void response();
}
