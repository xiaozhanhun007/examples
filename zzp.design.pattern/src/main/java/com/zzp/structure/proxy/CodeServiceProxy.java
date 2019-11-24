package com.zzp.structure.proxy;

/**
 * @Description 代理模式代理类
 * @Author Garyzeng
 * @since 2019.11.24
 **/
public class CodeServiceProxy implements CodeService{

    private CodeService codeService = new CodeServiceImpl();

    public void codeJava() {
        System.out.println("打开Java编辑器");
        codeService.codeJava();
        System.out.println("关闭Java编辑器");
    }

    public void codePython() {
        System.out.println("打开Python编辑器");
        codeService.codePython();
        System.out.println("关闭Python编辑器");
    }
}
