package com.zzp.design.open.close.principle;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 按钮类
 * @Author Garyzeng
 * @since 2020.07.15
 **/
public abstract class Button {

    private List<ButtonListener> listeners;

    public Button() {
        listeners = new LinkedList<ButtonListener>();
    }

    protected abstract void onPress();

    /**
     * 抽象出来按钮方法，按下
     */
    public void press() {
        this.onPress();
        for (ButtonListener listener : listeners) {
            listener.buttonPress();
        }
    }

    public void addListener(ButtonListener buttonListener) {
        if (buttonListener != null) {
            listeners.add(buttonListener);
        }
    }

}
