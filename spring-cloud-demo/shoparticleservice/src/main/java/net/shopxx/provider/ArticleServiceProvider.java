package net.shopxx.provider;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import net.shopxx.entity.Article;
import net.shopxx.service.ArticleService;

@RestController
@RequestMapping("/article")
public class ArticleServiceProvider {

	@Inject
	private ArticleService articleService;
	
	@GetMapping("/detail/{articleId}_{pageNumber}")
	@HystrixCommand
	public String detail(@PathVariable Long articleId, @PathVariable Integer pageNumber) {
		Article article = articleService.find(articleId);
		return "from shopbackend: " + JSON.toJSONString(article);
	}
}
