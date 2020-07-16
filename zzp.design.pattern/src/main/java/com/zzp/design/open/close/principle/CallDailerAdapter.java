package com.zzp.design.open.close.principle;

/**
 * @Description 拨号键适配器
 * @Author Garyzeng
 * @since 2020.07.15
 **/
public class CallDailerAdapter implements ButtonListener {

    private Dialer dialer = new Dialer();

    public void buttonPress() {
        dialer.call();
    }
}
