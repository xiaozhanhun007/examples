/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 * FileId: peucKcXjirTd+QhZAwSJS30hQ8NO0NGpJSkIIR/zhqM=
 */
package net.shopxx.service.impl;

import java.awt.image.BufferedImage;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.google.code.kaptcha.Producer;

import net.shopxx.service.CaptchaService;

/**
 * Service - 验证码
 * 
 * @author SHOP++ Team
 * @version 6.1
 */
@Service
public class CaptchaServiceImpl implements CaptchaService {

	/**
	 * "验证码"缓存名称
	 */
	private static final String CAPTCHA_CACHE_NAME = "captcha";

	@Inject
	private Producer captchaProducer;
	@Autowired
	private RedissonClient redissonClient;

	@Override
	public BufferedImage createImage(String captchaId) {
		Assert.hasText(captchaId, "[Assertion failed] - captchaId must have text; it must not be null, empty, or blank");

		String captcha = captchaProducer.createText();
		RBucket<String> rbucket = redissonClient.getBucket(CAPTCHA_CACHE_NAME+"_"+captchaId);
		rbucket.set(captcha);
		return captchaProducer.createImage(captcha);
	}

	@Override
	public boolean isValid(String captchaId, String captcha) {
		if (StringUtils.isEmpty(captchaId) || StringUtils.isEmpty(captcha)) {
			return false;
		}
		RBucket<String> rbucket = redissonClient.getBucket(CAPTCHA_CACHE_NAME+"_"+captchaId);
		if (rbucket != null && StringUtils.isNotBlank(rbucket.get())) {
			String value = rbucket.get();
			rbucket.delete();
			return StringUtils.equalsIgnoreCase(captcha, value);
		}
		return false;
	}

}