package com.hoolinks.dubbo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoolinks.dubbo.api.ShopService;

@RestController
public class ShopRest {
	
	@Autowired
	ShopService shopService;
	
	@GetMapping("/buy/{thing}")
	@ResponseBody
	public String buy(@PathVariable String thing) {
		System.out.println("Spring Service: " + shopService);
		// dubbo 服务映射为 spring cloud 服务
		return shopService.buy(thing);
	}
}
