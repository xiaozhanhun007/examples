package com.zzp.provider.controller;

import com.zzp.provider.entity.TSysUser;
import com.zzp.provider.service.ITSysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ITSysUserService tSysUserService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    @ResponseBody
    public TSysUser sendMessage() {
        TSysUser sysUser = tSysUserService.getById(1);
        return sysUser;
    }

}
