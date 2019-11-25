package com.zzp.structure.adapter;

/**
 * @Description 狗的类适配器测试
 * @author Garyzeng
 * @since 2019.11.25
 **/
public class DogClassAdapterTest {

    public static void main(String[] args) {
        Dog dog = new DogClassAdapter();
        dog.bark();
        dog.run();
    }

}
