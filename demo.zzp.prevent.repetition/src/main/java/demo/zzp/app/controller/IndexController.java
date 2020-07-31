package demo.zzp.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.com.rlid.utils.json.JsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.zzp.app.aop.annotation.PreventRepetitionAnnotation;

/**
 * index的控制层
 * @author karyzeng 2018.03.12
 * @version 1.0
 */
@Controller
public class IndexController {

	@RequestMapping(value = "/index",method = RequestMethod.GET)
	@PreventRepetitionAnnotation
	public String toIndex(HttpServletRequest request,Map<String, Object> map){
		
		return "form";
	}
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	@PreventRepetitionAnnotation
	public String add(HttpServletRequest request){
		try {
			//模拟执行业务逻辑需要的时间
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	 	return "sss";
	}
	
}
