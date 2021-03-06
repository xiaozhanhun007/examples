package com.zzp.provider.controller;

import com.string.util.StringUtils;
import com.zzp.base.enums.CommonJudgeEnum;
import com.zzp.base.mq.msg.vo.Message;
import com.zzp.provider.entity.TCoupon;
import com.zzp.provider.service.IMessageService;
import com.zzp.provider.service.ITCouponService;
import com.zzp.provider.service.ITSendMessageService;
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

    @Autowired
    private ITSendMessageService sendMessageService;

    @RequestMapping(value = "/sendMessage", method = RequestMethod.GET)
    @ResponseBody
    public TCoupon sendMessage() {
        TCoupon coupon = couponService.getById(1);
        Message<TCoupon> msg = new Message<TCoupon>();
        msg.setType("Coupon");
        msg.setData(coupon);
        msg.setMsgId(StringUtils.UUID());
        sendMessageService.saveMessageAndSendMq(msg);
        return coupon;
    }

    @RequestMapping(value = "/updateSendFlag", method = RequestMethod.GET)
    @ResponseBody
    public String updateSendFlag() {
        sendMessageService.updateSendFlag("f1a5983a195b467c8472fd7ad5c41de3", CommonJudgeEnum.NO.getId());
        return "修改成功";
    }

}
