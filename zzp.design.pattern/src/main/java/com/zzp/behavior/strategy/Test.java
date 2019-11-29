package com.zzp.behavior.strategy;

/**
 * @Description 策略模式测试
 * @Author Garyzeng
 * @since 2019.11.29
 **/
public class Test {

    public static void main(String[] args) {
        // 选择一个策略
        Drinks drinks = new TeaDrinks();
        // 使用策略
        Cup cup = new Cup(drinks);
        cup.make();
    }

}
