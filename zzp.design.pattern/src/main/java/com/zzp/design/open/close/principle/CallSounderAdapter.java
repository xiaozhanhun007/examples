package com.zzp.design.open.close.principle;

/**
 * @Description 拨号发声适配器类
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public class CallSounderAdapter implements ButtonListener{

    private Sounder sounder = new Sounder();

    public void buttonPress() {
        sounder.callSound();
    }
}
