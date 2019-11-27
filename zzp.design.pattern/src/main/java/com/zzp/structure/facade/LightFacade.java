package com.zzp.structure.facade;

/**
 * @Description 灯外观类
 * @author Garyzeng
 * @since 2019.11.28
 **/
public class LightFacade {

    private Light roadLight;

    private Light corridorLight;

    private Light toiletLight;

    public LightFacade() {
        this.roadLight = new RoadLight();
        this.corridorLight = new CorridorLight();
        this.toiletLight = new ToiletLigth();
    }

    public void roadLightOff() {
        System.out.println("关闭路灯");
    }

    public void roadLightOn() {
        System.out.println("打开路灯");
    }

    public void corridorLightOff() {
        System.out.println("关闭走廊灯");
    }

    public void corridorLightOn() {
        System.out.println("打开走廊灯");
    }

    public void toiletLightOff() {
        System.out.println("关闭厕所灯");
    }

    public void toiletLightOn() {
        System.out.println("打开厕所灯");
    }

}
