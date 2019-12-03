package com.zzp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @author karyzeng 2018.07.10
 * @version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.zzp"})
@EnableScheduling
@MapperScan("com.zzp.**.mapper")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);  
	}

}
