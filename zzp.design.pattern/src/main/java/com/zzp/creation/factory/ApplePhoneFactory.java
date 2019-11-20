package com.zzp.creation.factory;

import com.zzp.creation.simple.factory.Phone;

/**
 * @Description 苹果手机工厂
 * @Author Garyzeng
 * @since 2019.11.20
 **/
public class ApplePhoneFactory implements Factory{

    public Phone getPhone(String name) {
        if (name.equals("1")) {
            return new ApplePhone1();
        } else if(name.equals("2")) {
            return new ApplePhone2();
        }
        return null;
    }
}
