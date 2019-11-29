package com.zzp.behavior.strategy;

/**
 * @Description 茶饮料，代表具体的策略之一
 * @Author Garyzeng
 * @since 2019.11.26
 **/
public class TeaDrinks implements Drinks {

    public void make() {
        System.out.println("茶饮料被制作出来了");
    }
}
