/*
 * Copyright 2008-2018 shopxx.net. All rights reserved.
 * Support: http://www.shopxx.net
 * License: http://www.shopxx.net/license
 * FileId: N0JbvohtgleT957fbz8peF8KA+21rToJzzX69mhFbo0=
 */
package net.shopxx.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.beanutils.PropertyUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.redisson.Redisson;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.Assert;

import net.shopxx.CommonAttributes;
import net.shopxx.Setting;
import net.shopxx.TemplateConfig;

/**
 * Utils - 系统
 * 
 * @author SHOP++ Team
 * @version 6.1
 */
public final class SystemUtils {

	/**
	 * ConversionService
	 */
	private static final ConversionService CONVERSION_SERVICE = new DefaultConversionService();

	private final static String CONFIG_FILE = "bootstrap.properties";
	private static RedissonClient redissonClient;

	/**
	 * 不可实例化
	 */
	private SystemUtils() {
	}
	
	static {
		Properties pro = new Properties();
		InputStream in = null;
		try {
			in = new FileInputStream(CONFIG_FILE);
			pro.load(in);
			Config config = new Config();
			config.useSingleServer().setAddress("redis://" + pro.getProperty("spring.redis.host")+":"+pro.getProperty("spring.redis.port"));
			config.useSingleServer().setPassword(pro.getProperty("spring.redis.password"));
			redissonClient = Redisson.create(config);
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Cannot initial SystemUtils due to config file not found!");
		} catch (Exception e) {			
			System.out.println("Fail initial SystemUtils due to exception!");
			e.printStackTrace();
		} finally {
			if(in!=null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 获取系统设置
	 * 
	 * @return 系统设置
	 */
	@SuppressWarnings("unchecked")
	public static Setting getSetting() {
		RBucket<Setting> rbucket = redissonClient.getBucket(Setting.CACHE_NAME);
		if (rbucket.get() == null) {
			Setting setting = new Setting();
			try {
				File shopxxXmlFile = new File(CommonAttributes.SHOPXX_XML_PATH);
				Document document = new SAXReader().read(shopxxXmlFile);
				List<org.dom4j.Element> elements = document.selectNodes("/shopxx/setting");
				for (org.dom4j.Element element : elements) {
					try {
						String name = element.attributeValue("name");
						String value = element.attributeValue("value");
						Object property = CONVERSION_SERVICE.convert(value, PropertyUtils.getPropertyType(setting, name));
						PropertyUtils.setProperty(setting, name, property);//给属性赋值
					} catch (IllegalAccessException e) {
						throw new RuntimeException(e.getMessage(), e);
					} catch (InvocationTargetException e) {
						throw new RuntimeException(e.getMessage(), e);
					} catch (NoSuchMethodException e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}
			} catch (DocumentException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			rbucket.set(setting);
		}
		return rbucket.get();
	}

	/**
	 * 设置系统设置
	 * 
	 * @param setting
	 *            系统设置
	 */
	@SuppressWarnings("unchecked")
	public static void setSetting(Setting setting) {
		Assert.notNull(setting, "[Assertion failed] - setting is required; it must not be null");

		try {
			File shopxxXmlFile = new File(CommonAttributes.SHOPXX_XML_PATH);
			Document document = new SAXReader().read(shopxxXmlFile);
			List<org.dom4j.Element> elements = document.selectNodes("/shopxx/setting");
			for (org.dom4j.Element element : elements) {
				try {
					String name = element.attributeValue("name");
					String value = CONVERSION_SERVICE.convert(PropertyUtils.getProperty(setting, name), String.class);
					Attribute attribute = element.attribute("value");
					attribute.setValue(value);
				} catch (IllegalAccessException e) {
					throw new RuntimeException(e.getMessage(), e);
				} catch (InvocationTargetException e) {
					throw new RuntimeException(e.getMessage(), e);
				} catch (NoSuchMethodException e) {
					throw new RuntimeException(e.getMessage(), e);
				}
			}
			XMLWriter xmlWriter = null;
			try {
				OutputFormat outputFormat = OutputFormat.createPrettyPrint();
				outputFormat.setEncoding("UTF-8");
				outputFormat.setIndent(true);
				outputFormat.setIndent("	");
				outputFormat.setNewlines(true);
				xmlWriter = new XMLWriter(new FileOutputStream(shopxxXmlFile), outputFormat);
				xmlWriter.write(document);
				xmlWriter.flush();
			} catch (FileNotFoundException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage(), e);
			} finally {
				try {
					if (xmlWriter != null) {
						xmlWriter.close();
					}
				} catch (IOException e) {
				}
			}
			RBucket<Setting> rbucket = redissonClient.getBucket(Setting.CACHE_NAME);
			rbucket.set(setting);
		} catch (DocumentException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * 获取模板配置
	 * 
	 * @param id
	 *            ID
	 * @return 模板配置
	 */
	public static TemplateConfig getTemplateConfig(String id) {
		Assert.hasText(id, "[Assertion failed] - id must have text; it must not be null, empty, or blank");

		RBucket<TemplateConfig> rbucket = redissonClient.getBucket(TemplateConfig.CACHE_NAME+"_"+id);
		if (rbucket.get() == null) {
			TemplateConfig templateConfig = null;
			try {
				File shopxxXmlFile = new File(CommonAttributes.SHOPXX_XML_PATH);
				Document document = new SAXReader().read(shopxxXmlFile);
				org.dom4j.Element element = (org.dom4j.Element) document.selectSingleNode("/shopxx/templateConfig[@id='" + id + "']");
				if (element != null) {
					templateConfig = getTemplateConfig(element);
				}
			} catch (DocumentException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			rbucket.set(templateConfig);
		}
		return rbucket.get();
	}

	/**
	 * 获取模板配置
	 * 
	 * @param type
	 *            类型
	 * @return 模板配置
	 */
	@SuppressWarnings("unchecked")
	public static List<TemplateConfig> getTemplateConfigs(TemplateConfig.Type type) {
		String cacheKey = "templateConfigs_" + type;
		RBucket<List<TemplateConfig>> rbucket = redissonClient.getBucket(cacheKey);
		if (rbucket.get() == null) {
			List<TemplateConfig> templateConfigs = new ArrayList<>();
			try {
				File shopxxXmlFile = new File(CommonAttributes.SHOPXX_XML_PATH);
				Document document = new SAXReader().read(shopxxXmlFile);
				List<org.dom4j.Element> elements = document.selectNodes(type != null ? "/shopxx/templateConfig[@type='" + type + "']" : "/shopxx/templateConfig");
				for (org.dom4j.Element element : elements) {
					templateConfigs.add(getTemplateConfig(element));
				}
			} catch (DocumentException e) {
				throw new RuntimeException(e.getMessage(), e);
			}
			rbucket.set(templateConfigs);
		}
		return rbucket.get();
	}

	/**
	 * 获取所有模板配置
	 * 
	 * @return 所有模板配置
	 */
	public static List<TemplateConfig> getTemplateConfigs() {
		return getTemplateConfigs(null);
	}

	/**
	 * 获取模板配置
	 * 
	 * @param element
	 *            元素
	 * @return 模板配置
	 */
	private static TemplateConfig getTemplateConfig(org.dom4j.Element element) {
		Assert.notNull(element, "[Assertion failed] - element is required; it must not be null");

		String id = element.attributeValue("id");
		String type = element.attributeValue("type");
		String name = element.attributeValue("name");
		String templatePath = element.attributeValue("templatePath");
		String description = element.attributeValue("description");

		TemplateConfig templateConfig = new TemplateConfig();
		templateConfig.setId(id);
		templateConfig.setType(TemplateConfig.Type.valueOf(type));
		templateConfig.setName(name);
		templateConfig.setTemplatePath(templatePath);
		templateConfig.setDescription(description);
		return templateConfig;
	}

}