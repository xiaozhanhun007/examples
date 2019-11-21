package com.zzp.creation.abs.factory;

import com.zzp.creation.simple.factory.Phone;

/**
 * @Description 测试类
 * @Author Garyzeng
 * @since 2019.11.21
 **/
public class Test {

    public static void main(String[] args) {
        Factory factory = new XiaomiFactory();
        Phone phone = factory.getPhone();
        phone.showName();
        Computer computer = factory.getComputer();
        computer.showName();
        Router router = factory.getRouter();
        router.showName();
    }

}
