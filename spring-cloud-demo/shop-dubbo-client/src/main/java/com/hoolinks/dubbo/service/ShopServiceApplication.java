package com.hoolinks.dubbo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hoolinks.dubbo.api.ShopService;

@RestController
@ImportResource({"classpath*:dubbo-consumer-*.xml"})
@SpringBootApplication
public class ShopServiceApplication {
	
	@Autowired
	ShopService shopService;
	
	static ApplicationContext applicationContext;
	
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(ShopServiceApplication.class, args);

		Environment evn = applicationContext.getEnvironment();

		String[] profiles = evn.getDefaultProfiles();

		for (String profile : profiles) {
			System.out.println(profile);
		}
	}
	
	@GetMapping("/buy/{thing}")
	@ResponseBody
	public String buy(@PathVariable String thing) {
		System.out.println("Dubbo Service: " + shopService);
		// dubbo 服务映射为 spring cloud 服务
		return shopService.buy(thing);
	}
}
