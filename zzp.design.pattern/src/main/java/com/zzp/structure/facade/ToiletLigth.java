package com.zzp.structure.facade;

/**
 * @Description 厕所灯
 * @author Garyzeng
 * @since 2019.11.28
 **/
public class ToiletLigth implements Light {

    public void off() {
        System.out.println("关闭厕所灯");
    }

    public void on() {
        System.out.println("打开厕所灯");
    }
}
