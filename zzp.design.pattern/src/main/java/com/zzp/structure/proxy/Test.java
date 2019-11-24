package com.zzp.structure.proxy;

/**
 * @Description 代理测试
 * @Author Garyzeng
 * @since 2019.11.24
 **/
public class Test {

    public static void main(String[] args) {
        // 需要使用代理类
        CodeService codeService = new CodeServiceProxy();
        codeService.codeJava();
        codeService.codePython();
    }

}
