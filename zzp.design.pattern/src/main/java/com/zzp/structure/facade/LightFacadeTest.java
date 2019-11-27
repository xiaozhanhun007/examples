package com.zzp.structure.facade;

/**
 * @Description 外观类测试
 * @author Garyzeng
 * @since 2019.11.28
 **/
public class LightFacadeTest {

    public static void main(String[] args) {
        LightFacade facade = new LightFacade();
        facade.roadLightOff();
        facade.corridorLightOff();
        facade.toiletLightOff();
    }

}
