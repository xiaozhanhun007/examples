package com.zzp.design.dependency.inversion.principle;

/**
 * @Description 按钮类
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public class Button {

    private ButtonServer buttonServer;

    public Button(ButtonServer buttonServer) {
        this.buttonServer = buttonServer;
    }

    public void press(){
        buttonServer.turnOn();
    }

    public void release() {
        buttonServer.turnOff();
    }

}
