package com.zzp.provider.controller;

import com.alibaba.fastjson.JSON;
import com.string.util.StringUtils;
import com.zzp.base.mq.msg.vo.Message;
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
        sysUser.setAge(null);
        sysUserService.updateAllColumnById(sysUser);
        TCoupon coupon = couponService.getById(1);
//        Message<TCoupon> msg = new Message<TCoupon>();
//        msg.setType("Coupon");
//        msg.setData(coupon);
//        msg.setMsgId(StringUtils.UUID());
//        msg.setMsgId("0681171f156a4129bf33f1e5296test1");
//        messageService.sendMessage(JSON.toJSONString(msg));
        return coupon;
    }

}
