package com.zzp.design.open.close.principle;

/**
 * @Description 发声器
 * @Author Garyzeng
 * @since 2020.07.16
 **/
public class Sounder {

    public void numberSound(Integer token) {
        System.out.println("发出" + token+ "的声音");
    }

    public void callSound() {
        System.out.println("发出拨号的声音，嘟~嘟~嘟~");
    }

}
