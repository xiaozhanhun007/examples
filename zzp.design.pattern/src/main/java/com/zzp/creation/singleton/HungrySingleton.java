package com.zzp.creation.singleton;

/**
 * @Description 饿汉式单例模式
 * @Author karyzeng
 * @since 2019.09.06
 **/
public class HungrySingleton {

    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {};

    public static HungrySingleton getInstance() {
        return instance;
    }

}
