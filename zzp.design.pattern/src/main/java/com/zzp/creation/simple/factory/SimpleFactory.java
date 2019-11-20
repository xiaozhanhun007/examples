package com.zzp.creation.simple.factory;

/**
 * @Description 简单工厂模式
 * @Author Garyzeng
 * @since 2019.11.20
 **/
public class SimpleFactory {

    public Phone getPhone(String name) {
        if (name.equals("xiaomi")) {
            return new XiaomiPhone();
        } else if (name.equals("huawei")) {
            return new HuaweiPhone();
        } else if (name.equals("apple")) {
            return new ApplePhone();
        }
        return null;
    }

    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        Phone xiaomi = factory.getPhone("xiaomi");
        Phone huawei = factory.getPhone("huawei");
        Phone apple = factory.getPhone("apple");
        xiaomi.showName();
        huawei.showName();
        apple.showName();
    }

}
