package com.zzp.structure.bridge;

/**
 * @Description 大杯子
 * @Author Garyzeng
 * @since 2019.11.26
 **/
public class BigCup extends Cup {

    public BigCup(Drinks drinks) {
        super(drinks);
    }

    @Override
    public void show() {
        super.show();
        System.out.println("放进大杯子里面");
    }
}
