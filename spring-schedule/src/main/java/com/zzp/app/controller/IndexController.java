package com.zzp.app.controller;

import java.util.Map;

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
	
}
