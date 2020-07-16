package com.zzp.design.open.close.principle;

/**
 * @Description 数字键适配器
 * @Author Garyzeng
 * @since 2020.07.15
 **/
public class NumberDailerAdapter implements ButtonListener {

    private Integer token;

    private Dialer dialer = new Dialer();

    public NumberDailerAdapter(Integer token) {
        this.token = token;
    }

    public void buttonPress() {
        dialer.number(token);
    }
}
