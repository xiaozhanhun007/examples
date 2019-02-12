package com.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动类
 * @author zzp
 * @since 2018.03.04
 */
@Configuration  
@EnableAutoConfiguration  
@ComponentScan
public class Application {
	
	public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    }  
	
}
