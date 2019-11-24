package com.zzp.structure.proxy;

/**
 * @Description 代理模式实现类
 * @Author Garyzeng
 * @since 2019.11.24
 **/
public class CodeServiceImpl implements CodeService {

    public void codeJava() {
        System.out.println("编写Java程序");
    }

    public void codePython() {
        System.out.println("编写Python程序");
    }
}
