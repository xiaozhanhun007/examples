package com.zzp.structure.bridge;

/**
 * @Description 桥梁模式测试
 * @Author Garyzeng
 * @since 2019.11.26
 **/
public class Test {

    public static void main(String[] args) {
        SmallCup teaSmallCup = new SmallCup(new TeaDrinks());
        teaSmallCup.show();

        SmallCup fruitsSmallCup = new SmallCup(new FruitsDrinks());
        fruitsSmallCup.show();

        BigCup teaBigCup = new BigCup(new TeaDrinks());
        teaBigCup.show();

        BigCup fruitsBigCup = new BigCup(new FruitsDrinks());
        fruitsBigCup.show();
    }

}
