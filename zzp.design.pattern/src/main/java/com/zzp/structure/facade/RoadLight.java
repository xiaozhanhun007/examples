package com.zzp.structure.facade;

/**
 * @Description 路灯
 * @author Garyzeng
 * @since 2019.11.28
 **/
public class RoadLight implements Light {

    public void off() {
        System.out.println("关闭路灯");
    }

    public void on() {
        System.out.println("打开路灯");
    }
}
