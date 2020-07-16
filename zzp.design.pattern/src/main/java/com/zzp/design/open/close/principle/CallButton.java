package com.zzp.design.open.close.principle;

/**
 * @Description 拨号按钮
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public class CallButton extends Button{

    @Override
    public void onPress() {
        System.out.println("拨号按钮被按下了，需要改变状态");
    }
}
