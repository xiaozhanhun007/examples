package com.hoolinks.dubbo.impl;

import org.springframework.stereotype.Service;

import com.hoolinks.dubbo.api.ShopService;

@Service("shopService")
public class ShopServiceImpl implements ShopService{

	@Override
	public String buy(String thing) {
		System.out.println("Buy: " + thing);
		
		return "Buy: " + thing;
	}

}
