package com.zzp.behavior.observer;

/**
 * @Description 订单观察者
 * @Author Garyzeng
 * @since 2019.12.04
 **/
public class OrderObserver extends Observer {

    public OrderObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void response() {
        Integer status = this.subject.getStatus();
        System.out.println("数据发生变化，status变为：" + status + "，订单观察者需要作出响应");
    }
}
