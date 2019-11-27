package com.zzp.structure.decorator;

/**
 * @Description 柠檬-作为Decorator接口的实现类
 * @Author Garyzeng
 * @since 2019.11.27
 **/
public class Lemon implements Condiment{

    private Drinks drinks;

    public Lemon(Drinks drinks) {
        this.drinks = drinks;
    }

    public String description() {
        return drinks.description() + "，加柠檬";
    }

    public Double price() {
        return drinks.price() + 2;
    }
}
