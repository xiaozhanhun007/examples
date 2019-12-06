package com.zzp.behavior.template;

/**
 * @Description 模板方法测试
 * @Author Garyzeng
 * @since 2019.12.06
 **/
public class Test {

    public static void main(String[] args) {
        MiniSuvTemplate chr = new CHR();
        MiniSuvTemplate izoa = new IZOA();
        chr.create();
        izoa.create();
    }

}
