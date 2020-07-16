package com.zzp.design.open.close.principle;

/**
 * @Description 数字发声适配器类
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public class NumberSounderAdapter implements ButtonListener{

    private Integer token;

    private Sounder sounder = new Sounder();

    public NumberSounderAdapter(Integer token) {
        this.token = token;
    }

    public void buttonPress() {
        sounder.numberSound(token);
    }
}
