package com.zzp.structure.decorator;

/**
 * @Description 金桔-作为Decorator接口的实现类
 * @Author Garyzeng
 * @since 2019.11.27
 **/
public class Kumquat implements Condiment{

    private Drinks drinks;

    public Kumquat(Drinks drinks) {
        this.drinks = drinks;
    }

    public String description() {
        return drinks.description() + "，加金桔";
    }

    public Double price() {
        return drinks.price() + 3;
    }
}
