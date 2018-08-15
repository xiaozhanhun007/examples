package guo.com.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

import com.hoolinks.dubbo.api.ShopService;

@SpringBootApplication
@EnableFeignClients({"com.hoolinks","guo.com"})
public class CloudClient 
{
	
    public static void main( String[] args )
    {
    	ApplicationContext applicationContext = SpringApplication.run(CloudClient.class, args);
    	
//    	RestTemplate restTemplate = (RestTemplate)applicationContext.getBean("restTemplate");
//    	System.out.println(restTemplate.getForObject("http://SHOPARTICLESERVICE-GUO/article/detail/1_0", String.class));
    	
//    	RestTemplate restTemplate = (RestTemplate)applicationContext.getBean("restTemplate");
//    	System.out.println(restTemplate.getForObject("http://SHOP-DUBBO-SERVICE/buy/All", String.class));
    	
    	ShopService service = (ShopService)applicationContext.getBean(ShopService.class);
    	System.out.println("Cloud Service: " + service);
    	System.out.println(service.buy("what?"));
    	
//    	ArticleServiceClient client = (ArticleServiceClient)applicationContext.getBean(ArticleServiceClient.class);
//    	System.out.println(client.detail(1L, 0));
    }
}
