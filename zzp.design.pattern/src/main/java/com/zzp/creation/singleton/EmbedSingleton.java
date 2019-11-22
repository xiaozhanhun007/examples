package com.zzp.creation.singleton;

/**
 * @Description 内嵌式单例模式，对懒汉的优化
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class EmbedSingleton {

    private EmbedSingleton() {};

    private static class Holder {
        private static EmbedSingleton singleton = new EmbedSingleton();
    }

    public static EmbedSingleton getInstance() {
        return Holder.singleton;
    }

}
