package com.zzp.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author karyzeng
 * @since 2019.07.03
 **/
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @ResponseBody
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

}
