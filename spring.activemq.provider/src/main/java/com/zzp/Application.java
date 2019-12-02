package com.zzp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 启动类
 * @author karyzeng 2018.07.10
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.zzp"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);  
	}

}
