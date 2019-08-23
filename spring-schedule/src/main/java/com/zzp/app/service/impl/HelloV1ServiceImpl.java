package com.zzp.app.service.impl;

import com.zzp.app.service.HelloService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.08.22
 **/
@Service
public class HelloV1ServiceImpl implements HelloService, DisposableBean, InitializingBean {

    @Override
    public void sayHello() {
        System.out.println("V1:Hello");
    }

    @Override
    public void sayHi() {
        System.out.println("V1:Hi");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("V1:销毁了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("V1:初始化完");
        sayHello();
    }
}
