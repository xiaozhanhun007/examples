package com.zzp.design.dependency.inversion.principle;

/**
 * @Description 依赖倒置原则的抽象接口类
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public interface ButtonServer {

    /**
     * 打开方法
     */
    void turnOn();

    /**
     * 关闭方法
     */
    void turnOff();

}
