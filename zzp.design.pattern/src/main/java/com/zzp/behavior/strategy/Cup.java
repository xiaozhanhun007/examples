package com.zzp.behavior.strategy;

/**
 * @Description 杯子，表示使用策略的类
 * @Author Garyzeng
 * @since 2019.11.29
 **/
public class Cup {

    private Drinks drinks;

    public Cup(Drinks drinks) {
        this.drinks = drinks;
    }

    public void make() {
        this.drinks.make();
        System.out.println("将饮料放进杯子并包装起来，一杯饮料做好了");
    }

}
