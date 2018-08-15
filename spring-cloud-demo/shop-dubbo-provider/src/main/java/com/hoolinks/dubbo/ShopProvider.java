package com.hoolinks.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ImportResource({"classpath*:dubbo-provider-*.xml"})
public class ShopProvider {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(ShopProvider.class, args);
		
		Environment evn = applicationContext.getEnvironment();
		
		String[] profiles = evn.getDefaultProfiles();
		
		for (String profile : profiles) {
			System.out.println(profile);
		}
	}
}
