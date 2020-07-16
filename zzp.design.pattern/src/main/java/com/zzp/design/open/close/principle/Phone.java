package com.zzp.design.open.close.principle;

/**
 * @Description 手机类
 * @Author Garyzeng
 * @since 2020.07.15
 **/
public class Phone {

    private Dialer dialer;

    private Button[] numberButtons;

    private Button callButton;

    public Phone() {
        this.dialer = new Dialer();
        callButton = new CallButton();
        numberButtons = new Button[10];
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new NumberButton();
            numberButtons[i].addListener(new NumberDailerAdapter(i));
            numberButtons[i].addListener(new NumberSounderAdapter(i));
        }
        callButton.addListener(new CallDailerAdapter());
        callButton.addListener(new CallSounderAdapter());
    }

    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.numberButtons[1].press();
        phone.numberButtons[1].press();
        phone.numberButtons[0].press();
        phone.callButton.press();
    }



}
