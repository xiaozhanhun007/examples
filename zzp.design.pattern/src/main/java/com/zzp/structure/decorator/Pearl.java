package com.zzp.structure.decorator;

/**
 * @Description 珍珠-作为Decorator接口的实现类
 * @Author Garyzeng
 * @since 2019.11.27
 **/
public class Pearl implements Condiment{

    private Drinks drinks;

    public Pearl(Drinks drinks) {
        this.drinks = drinks;
    }

    public String description() {
        return drinks.description() + "，加珍珠";
    }

    public Double price() {
        return drinks.price() + 1.5;
    }
}
