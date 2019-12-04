package com.zzp.behavior.observer;

/**
 * @Description 观察者模式测试
 * @Author Garyzeng
 * @since 2019.12.04
 **/
public class Test {

    public static void main(String[] args) {
        Subject subject = new Subject();

        Observer orderObserver = new OrderObserver(subject);
        subject.addObserver(orderObserver);

        Observer mailObserver = new MailObserver(subject);
        subject.addObserver(mailObserver);

        subject.setStatus(1);
        subject.setStatus(2);
    }

}
