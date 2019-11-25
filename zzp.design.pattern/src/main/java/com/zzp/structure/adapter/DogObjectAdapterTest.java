package com.zzp.structure.adapter;

/**
 * @Description 狗的对象适配器测试
 * @author Garyzeng
 * @since 2019.11.25
 **/
public class DogObjectAdapterTest {

    public static void main(String[] args) {
        // 创建一只猫
        Cat cat = new PersianCat();
        // 将猫适配成狗
        Dog dog = new DogObjectAdapter(cat);
        dog.bark();
        dog.run();
    }

}
