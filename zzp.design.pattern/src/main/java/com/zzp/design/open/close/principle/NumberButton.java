package com.zzp.design.open.close.principle;

/**
 * @Description 数字按钮
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public class NumberButton extends Button{

    @Override
    public void onPress() {
        System.out.println("数字按钮被按下了，需要改变状态");
    }
}
