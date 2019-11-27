package com.zzp.structure.decorator;

/**
 * @Description 装饰器模式测试
 * @Author Garyzeng
 * @since 2019.11.27
 **/
public class Test {

    public static void main(String[] args) {
        Drinks drinks1 = new Honey(new Kumquat(new Pearl(new Pearl(new GreenTea()))));
        System.out.println(drinks1.description() + "，价格：" + drinks1.price());

        Drinks drinks2 = new Honey(new Kumquat(new Pearl(new Coffee())));
        System.out.println(drinks2.description() + "，价格：" + drinks2.price());
    }

}
