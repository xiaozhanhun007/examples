package com.zzp.behavior.template;

/**
 * @Description 丰田小型SUV模板
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public abstract class MiniSuvTemplate {

    public void create() {
        assembleTyre();
        assembleChassis();
        assembleCarBody();
    }

    private void assembleTyre() {
        System.out.println("使用丰田小型SVU轮胎");
    }

    private void assembleChassis() {
        System.out.println("使用丰田小型SVU底盘");
    }

    protected abstract void assembleCarBody();

}
