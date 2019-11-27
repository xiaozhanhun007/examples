package com.zzp.structure.decorator;

/**
 * @Description 咖啡-作为Component实现类
 * @Author Garyzeng
 * @since 2019.11.27
 **/
public class Coffee implements Drinks{

    public String description() {
        return "咖啡";
    }

    public Double price() {
        return 9.6;
    }
}
