package com.zzp.structure.facade;

/**
 * @Description 走廊灯
 * @author Garyzeng
 * @since 2019.11.28
 **/
public class CorridorLight implements Light {

    public void off() {
        System.out.println("关闭走廊灯");
    }

    public void on() {
        System.out.println("打开走廊灯");
    }
}
