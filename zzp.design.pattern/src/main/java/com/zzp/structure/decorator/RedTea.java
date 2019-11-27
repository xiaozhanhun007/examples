package com.zzp.structure.decorator;

/**
 * @Description 红茶-作为Component实现类
 * @Author Garyzeng
 * @since 2019.11.27
 **/
public class RedTea implements Drinks{

    public String description() {
        return "红茶";
    }

    public Double price() {
        return 6.6;
    }
}
