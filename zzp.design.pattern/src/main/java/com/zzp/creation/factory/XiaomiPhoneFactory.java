package com.zzp.creation.factory;

import com.zzp.creation.simple.factory.Phone;

/**
 * @Description 小米手机工厂
 * @Author Garyzeng
 * @since 2019.11.20
 **/
public class XiaomiPhoneFactory implements Factory{

    public Phone getPhone(String name) {
        if (name.equals("1")) {
            return new XiaomiPhone1();
        } else if(name.equals("2")) {
            return new XiaomiPhone2();
        }
        return null;
    }
}
