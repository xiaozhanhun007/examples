package com.zzp.structure.bridge;

/**
 * @Description 杯子抽象类
 * @Author Garyzeng
 * @since 2019.11.26
 **/
public abstract class Cup {

    private Drinks drinks;

    public Cup(Drinks drinks) {
        this.drinks = drinks;
    }

    public void show(){
        drinks.make();
    }

}
