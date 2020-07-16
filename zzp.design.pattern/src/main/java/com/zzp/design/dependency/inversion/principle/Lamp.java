package com.zzp.design.dependency.inversion.principle;

/**
 * @Description 灯
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public class Lamp implements ButtonServer{

    /**
     * 灯的状态，0表示熄灭了，1表示亮了
     */
    private Integer status;

    public Lamp(){
        status = 0;
    }

    public void turnOn() {
        status = 1;
        System.out.println("灯亮了");
    }

    public void turnOff() {
        status = 0;
        System.out.println("灯熄灭了");
    }
}
