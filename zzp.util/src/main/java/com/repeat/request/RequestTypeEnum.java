package com.repeat.request;

/**
 * 请求类型枚举
 * 
 * @author karyzeng
 * @since 2018.09.03
 *
 */
public enum RequestTypeEnum {

	YL(1, "易流"),
	BD(2, "百度");
	
	private int type;
	
	private String name;
	
	private RequestTypeEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

}
