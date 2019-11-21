package com.zzp.creation.abs.factory;

import com.zzp.creation.simple.factory.ApplePhone;
import com.zzp.creation.simple.factory.Phone;

/**
 * @Description 苹果工厂
 * @Author Garyzeng
 * @since 2019.11.21
 **/
public class AppleFactory implements Factory {

    public Phone getPhone() {
        return new ApplePhone();
    }

    public Computer getComputer() {
        return new AppleComputer();
    }

    public Router getRouter() {
        return new AppleRouter();
    }
}
