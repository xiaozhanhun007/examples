package net.shopxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableCircuitBreaker
@ImportResource({"applicationContext.xml"})
public class ShopArticleService 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(ShopArticleService.class);
    }
}
