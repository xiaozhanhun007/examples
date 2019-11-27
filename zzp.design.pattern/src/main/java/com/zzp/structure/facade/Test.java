package com.zzp.structure.facade;

/**
 * @Description 测试
 * @author Garyzeng
 * @since 2019.11.28
 **/
public class Test {

    public static void main(String[] args) {
        Light roadLight = new RoadLight();
        roadLight.off();

        Light corridorLight = new CorridorLight();
        corridorLight.off();

        Light toiletLight = new ToiletLigth();
        toiletLight.off();
    }

}
