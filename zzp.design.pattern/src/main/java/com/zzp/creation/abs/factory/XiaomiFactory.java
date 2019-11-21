package com.zzp.creation.abs.factory;

import com.zzp.creation.simple.factory.Phone;
import com.zzp.creation.simple.factory.XiaomiPhone;

/**
 * @Description 小米工厂
 * @Author Garyzeng
 * @since 2019.11.21
 **/
public class XiaomiFactory implements Factory {

    public Phone getPhone() {
        return new XiaomiPhone();
    }

    public Computer getComputer() {
        return new XiaomiComputer();
    }

    public Router getRouter() {
        return new XiaomiRouter();
    }
}
