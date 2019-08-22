package com.zzp.app.service.impl;

import com.zzp.app.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.08.22
 **/
@Service
public class HelloV2ServiceImpl implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("V2:Hello");
    }

    @Override
    public void sayHi() {
        System.out.println("V2:Hi");
    }
}
