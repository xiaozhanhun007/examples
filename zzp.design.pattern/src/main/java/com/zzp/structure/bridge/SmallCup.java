package com.zzp.structure.bridge;

/**
 * @Description 小杯子
 * @Author Garyzeng
 * @since 2019.11.26
 **/
public class SmallCup extends Cup {

    public SmallCup(Drinks drinks) {
        super(drinks);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("放进小杯子里面");
    }
}
