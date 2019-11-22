package com.zzp.creation.singleton;

/**
 * @Description 测试类
 * @Author Garyzeng
 * @since 2019.11.22
 **/
public class Test {

    public static void main(String[] args) {
        // 懒汉式测试
        HungrySingleton hungrySingleton1 = HungrySingleton.getInstance();
        HungrySingleton hungrySingleton2 = HungrySingleton.getInstance();
        System.out.println("hungrySingleton1 == hungrySingleton2: " + (hungrySingleton1 == hungrySingleton2));

        // 饱汉式测试
        FullSingleton fullSingleton1 = FullSingleton.getInstance();
        FullSingleton fullSingleton2 = FullSingleton.getInstance();
        System.out.println("fullSingleton1 == fullSingleton2: " + (fullSingleton1 == fullSingleton2));

        // 嵌入式测试
        EmbedSingleton embedSingleton1 = EmbedSingleton.getInstance();
        EmbedSingleton embedSingleton2 = EmbedSingleton.getInstance();
        System.out.println("embedSingleton1 == embedSingleton2: " + (embedSingleton1 == embedSingleton2));
    }

}
