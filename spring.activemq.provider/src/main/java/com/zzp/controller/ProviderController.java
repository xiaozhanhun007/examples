package com.zzp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 消息提供者controller
 * @Author Garyzeng
 * @since 2019.12.01
 **/
@Controller
@RequestMapping(value = "/provider")
public class ProviderController {

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    @ResponseBody
    public String sendMessage() {
        System.out.println(1/0);
        return null;
    }

}
