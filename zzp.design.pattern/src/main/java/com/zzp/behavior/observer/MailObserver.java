package com.zzp.behavior.observer;

/**
 * @Description 邮件观察者
 * @Author Garyzeng
 * @since 2019.12.04
 **/
public class MailObserver extends Observer {

    public MailObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void response() {
        Integer status = this.subject.getStatus();
        System.out.println("数据发生变化，status变为：" + status + "，邮件观察者需要作出响应");
    }
}
