package com.zzp.creation.abs.factory;

import com.zzp.creation.simple.factory.Phone;

/**
 * @Description 抽象工厂接口
 * @Author Garyzeng
 * @since 2019.11.21
 **/
public interface Factory {

    Phone getPhone();

    Computer getComputer();

    Router getRouter();

}
