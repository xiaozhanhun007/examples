package com.zzp.dynamic.proxy.text;

import java.lang.reflect.Proxy;

/**
 * 代理测试类
 * @author Garyzeng
 * @since 2019.10.27
 */
public class CodeProxyTest {

    public static void main(String[] args) {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        CodeInvocationHandler invocationHandler = new CodeInvocationHandler(new CodeServiceImpl());
        CodeService codeServiceProxy = (CodeService) Proxy.newProxyInstance(CodeProxyTest.class.getClassLoader(), new Class[]{CodeService.class}, invocationHandler);
        codeServiceProxy.codeJava();
    }

}
