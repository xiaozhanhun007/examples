package com.zzp.structure.decorator;

/**
 * @Description 蜂蜜-作为Decorator接口的实现类
 * @Author Garyzeng
 * @since 2019.11.27
 **/
public class Honey implements Condiment{

    private Drinks drinks;

    public Honey(Drinks drinks) {
        this.drinks = drinks;
    }

    public String description() {
        return drinks.description() + "，加蜂蜜";
    }

    public Double price() {
        return drinks.price() + 1;
    }
}
