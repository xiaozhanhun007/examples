package com.zzp.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
public class IndexController {

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	@ResponseBody
	public String toIndex(HttpServletRequest request,Map<String, Object> map){
		return "form";
	}
	
}
