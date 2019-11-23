package com.zzp.creation.builder;

/**
 * @Description 建造者模式测试
 * @Author Garyzeng
 * @since 2019.11.23
 **/
public class Test {

    public static void main(String[] args) {
        Config config = Config.builder().
                ip("127.0.0.1").
                port("8093").
                username("金甲卡卡龙").
                isCache(true).
                build();
        System.out.println(config);
    }

}
