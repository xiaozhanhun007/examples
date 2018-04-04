package demo.zzp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 启动类
 * @author karyzeng 2018.03.04
 * @version 1.0
 */
@SpringBootApplication
@Configuration  
@EnableAutoConfiguration  
@ComponentScan
public class Application {
	
	public static void main(String[] args) {  
        SpringApplication.run(Application.class, args);  
    }  
	
}
