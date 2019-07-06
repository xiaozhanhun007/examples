package com.zzp.app.controller;

import com.zzp.app.sms.SmsCode;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 手机验证码Controller
 * @Author karyzeng
 * @since 2019.07.03
 **/
@Controller
@RequestMapping(value = "/smsCode")
public class SmsCodeController {

    public final static String SESSION_KEY_SMS_CODE = "SESSION_KEY_SMS_CODE";

    @Autowired
    private SessionStrategy sessionStrategy;

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public void getSmsCodeByMobile(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value = "mobile", required = true) String mobile
    ){
        SmsCode smsCode = createSMSCode();
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY_SMS_CODE + mobile, smsCode);
        System.out.println("验证码为：" + smsCode.getCode());
    }

    private SmsCode createSMSCode() {
        String code = RandomStringUtils.randomNumeric(6);
        return new SmsCode(code, 60);
    }

}
