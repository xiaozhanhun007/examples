package com.zzp.app.controller;

import javax.servlet.http.HttpServletRequest;

import com.zzp.app.config.RountingInjected;
import com.zzp.app.service.HelloService;
import com.zzp.app.vo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RountingInjected(value = "helloV2ServiceImpl")
	private HelloService helloService;

	@RequestMapping(value = "/test",method = RequestMethod.POST)
	@ResponseBody
	public Object test(HttpServletRequest request, @RequestBody User userDto){
		logger.info(userDto.toString());
		helloService.sayHello();
		helloService.sayHi();
		return userDto;
	}

	@RequestMapping(value = "/test2",method = RequestMethod.GET)
	@ResponseBody
	public Object test2(HttpServletRequest request,
						@RequestParam(value = "id", required = true) Integer id,
						@RequestParam(value = "userName", required = true) String userName,
						@RequestParam(value = "loginId", required = true) String loginId){
		User user = new User();
		user.setId(id);
		user.setUserName(userName);
		user.setLoginId(loginId);
		return user;
	}

}
