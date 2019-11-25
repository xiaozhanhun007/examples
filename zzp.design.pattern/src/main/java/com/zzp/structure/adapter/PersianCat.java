package com.zzp.structure.adapter;

/**
 * @Description 波斯猫
 * @author Garyzeng
 * @since 2019.11.25
 */
public class PersianCat implements Cat{

    public void meow() {
        System.out.println("猫喵喵叫");
    }

    public void run() {
        System.out.println("猫跑起来了");
    }
}
