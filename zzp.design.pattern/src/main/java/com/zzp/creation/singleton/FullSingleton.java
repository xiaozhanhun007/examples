package com.zzp.creation.singleton;

/**
 * @Description 饱汉式单例模式
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class FullSingleton {

    // 变量必须要用volatile变量修饰
    private volatile static FullSingleton singleton = null;

    private FullSingleton() {

    }

    public static FullSingleton getInstance() {
        if (singleton == null) {
            synchronized (FullSingleton.class) {
                if (singleton == null) {
                    singleton = new FullSingleton();
                }
            }
        }
        return singleton;
    }

}
