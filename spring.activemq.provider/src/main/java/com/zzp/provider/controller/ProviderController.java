package com.zzp.provider.controller;

import com.alibaba.fastjson.JSON;
import com.zzp.provider.entity.TCoupon;
import com.zzp.provider.entity.TSysUser;
import com.zzp.provider.service.IMessageService;
import com.zzp.provider.service.ITCouponService;
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
    private ITSysUserService sysUserService;

    @Autowired
    private ITCouponService couponService;

    @Autowired
    private IMessageService messageService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    @ResponseBody
    public TCoupon sendMessage() {
        TSysUser sysUser = sysUserService.getById(1);
        TCoupon coupon = couponService.getById(1);
        messageService.sendMessage(JSON.toJSONString(coupon));
        return coupon;
    }

}
