package com.hoolinks.dubbo.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author zzp
 *
 */
@FeignClient("SHOP-DUBBO-PROVIDER")
public interface ShopService {
	
	@RequestMapping(method = RequestMethod.GET, value = "/buy/{thing}")
	public String buy(@PathVariable("thing") String thing);
}