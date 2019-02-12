package com.mail.util;

import com.mail.util.MailSenderInfo;
import com.mail.util.SimpleMailSender;

public class SendMailTest {

	public static void main(String[] args) {
		MailSenderInfo mailInfo = new MailSenderInfo();   
	      mailInfo.setMailServerHost("smtp.toyotsu-ea.com");   
	      mailInfo.setMailServerPort("25");   
	      mailInfo.setValidate(true);   
	      mailInfo.setUserName("ttgclogistics_service@sys.toyotsu-ea.com");   
	      mailInfo.setPassword("TTCChina_476");//您的邮箱密码   
	      mailInfo.setFromAddress("ttgclogistics_service@sys.toyotsu-ea.com");   
	      mailInfo.setToAddress("354697171@qq.com");   
	      mailInfo.setSubject("你好");   
	      mailInfo.setContent("大海0044");   
	        //这个类主要来发送邮件  
	      SimpleMailSender sms = new SimpleMailSender();  
	      boolean textMail = sms.sendTextMail(mailInfo);//发送文体格式   
	      if (textMail) {
	    	  System.out.println("发送结果：" + textMail);
	      }
//	         sms.sendHtmlMail(mailInfo);//发送html格式
	}

}
