package com.mail.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.mail.util.MailSenderInfo;
import com.mail.util.SimpleMailSender;

/**
 * test
 * @author zzp
 * @since 2018.03.04
 */
@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping(value = "hello",method = RequestMethod.GET)
	@ResponseBody
	public String hello(@RequestParam(value = "name",required = true)String name){
		return "hello world " + name;
	}
	
	@RequestMapping(value = "sendMailOld",method = RequestMethod.GET)
	@ResponseBody
	public String sendMailOld(@RequestParam(value = "content",required = true)String content){
		MailSenderInfo mailInfo = new MailSenderInfo();   
	    mailInfo.setMailServerHost("mail.ttni.com.cn");   
	    mailInfo.setMailServerPort("587");   
	    mailInfo.setValidate(true);
	    mailInfo.setTrust(false);
	    mailInfo.setUserName("ttgclogistics_service@gzcn.toyotsu.net");   
	    mailInfo.setPassword("0110@CQY8#");//您的邮箱密码   
	    mailInfo.setFromAddress("ttgclogistics_service@gzcn.toyotsu.net");   
	    mailInfo.setToAddress("zengzhenpeng@hoolinks.com");   
	    mailInfo.setSubject("test");   
	    mailInfo.setContent(content);
	    System.out.println("sendMailOld发送邮件内容：" + JSON.toJSONString(mailInfo));
	    //这个类主要来发送邮件  
	    SimpleMailSender sms = new SimpleMailSender();  
	    boolean textMail = sms.sendTextMail(mailInfo);//发送文体格式   
	    if (textMail) {
	    	System.out.println("发送结果：" + textMail);
	     }
		return "发送结果 " + textMail;
	}
	
	@RequestMapping(value = "sendMailNew",method = RequestMethod.GET)
	@ResponseBody
	public String sendMailNew(@RequestParam(value = "content",required = true)String content){
		MailSenderInfo mailInfo = new MailSenderInfo();   
	    mailInfo.setMailServerHost("smtp.toyotsu-ea.com");   
	    mailInfo.setMailServerPort("587");   
	    mailInfo.setValidate(true);
	    mailInfo.setTrust(true);
	    mailInfo.setUserName("ttgclogistics_service@sys.toyotsu-ea.com");   
	    mailInfo.setPassword("TTCChina_476");//您的邮箱密码   
	    mailInfo.setFromAddress("ttgclogistics_service@sys.toyotsu-ea.com");   
	    mailInfo.setToAddress("zengzhenpeng@hoolinks.com");   
	    mailInfo.setSubject("test");   
	    mailInfo.setContent(content);
	    System.out.println("sendMailNew发送邮件内容：" + JSON.toJSONString(mailInfo));
	    //这个类主要来发送邮件  
	    SimpleMailSender sms = new SimpleMailSender();  
	    boolean textMail = sms.sendTextMail(mailInfo);//发送文体格式   
	    if (textMail) {
	    	System.out.println("发送结果：" + textMail);
	     }
		return "发送结果 " + textMail;
	}
}
