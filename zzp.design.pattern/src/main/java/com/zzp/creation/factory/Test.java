package com.zzp.creation.factory;

import com.zzp.creation.simple.factory.Phone;

/**
 * @Description 测试类
 * @Author Garyzeng
 * @since 2019.11.20
 **/
public class Test {

    public static void main(String[] args) {
        Factory xiaomiFactory = new XiaomiPhoneFactory();
        Phone xiaomi = xiaomiFactory.getPhone("1");
        xiaomi.showName();

        Factory appleFactory = new ApplePhoneFactory();
        Phone apple = appleFactory.getPhone("2");
        apple.showName();
    }

}
