package com.zzp.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.zzp.app.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index的控制层
 * @author karyzeng 2018.03.12
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/test",method = RequestMethod.GET)
	@ResponseBody
	public Object test(HttpServletRequest request,Map<String, Object> map){
		User user = new User();
		user.setId(1);
		user.setLoginId("zzp");
		user.setUserName("小朋司机");
		user = null;
		if (user == null) {
			throw new RuntimeException();
		}
		logger.info(user.toString());
		return user;
	}
	
}
