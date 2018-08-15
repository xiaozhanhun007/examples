package guo.com.springcloud.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("SHOPARTICLESERVICE-GUO")
//@FeignClient("${b2b.articleservicename:SHOPARTICLESERVICE}")
public interface ArticleServiceClient {

	@RequestMapping(method = RequestMethod.GET, value = "/article/detail/{articleId}_{pageNumber}")
	public String detail(@RequestParam("articleId") Long articleId, @RequestParam("pageNumber") Integer pageNumber);
	
}
