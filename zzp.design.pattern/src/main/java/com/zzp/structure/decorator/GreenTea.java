package com.zzp.structure.decorator;

/**
 * @Description 绿茶-作为Component实现类
 * @Author Garyzeng
 * @since 2019.11.27
 **/
public class GreenTea implements Drinks{

    public String description() {
        return "绿茶";
    }

    public Double price() {
        return 5.6;
    }
}
