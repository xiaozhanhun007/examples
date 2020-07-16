package com.zzp.design.open.close.principle;

/**
 * @Description 拨号器类
 * @Author Garyzeng
 * @since 2020.07.15
 **/
public class Dialer {

    public void number(Integer token) {
        System.out.println("数字键：" + token);
    }

    public void call() {
        System.out.println("拨号");
    }
}
