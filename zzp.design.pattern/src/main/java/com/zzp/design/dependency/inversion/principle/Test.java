package com.zzp.design.dependency.inversion.principle;

/**
 * @Description 开关
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public class Test {

    public static void main(String[] args) {
        Button button = new Button(new Lamp());
        button.press();
        button.release();
    }

}
