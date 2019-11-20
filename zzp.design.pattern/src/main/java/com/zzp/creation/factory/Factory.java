package com.zzp.creation.factory;

import com.zzp.creation.simple.factory.Phone;

/**
 * @Description 工厂接口
 * @Author Garyzeng
 * @since 2019.11.20
 **/
public interface Factory {

    Phone getPhone(String name);

}
