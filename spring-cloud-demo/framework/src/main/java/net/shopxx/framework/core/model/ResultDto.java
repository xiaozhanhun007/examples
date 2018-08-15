/*
 * Copyright 2018-2019 xiehs. All rights reserved.
 * 
 * 
 */
package net.shopxx.framework.core.model;

/**
 * 消息
 * 
 * @author xiehs
 * @version 1.0
 */
public class ResultDto {

	public enum Type {

		/** 成功 */
		success,

		/** 警告 */
		warn,

		/** 错误 */
		error
	}

	/** 类型 */
	private Type type=ResultDto.Type.success;
	/** 返回的提示信息 */
	private String message="操作成功";
	/**
	 * 返回的数据
	 */
	private Object data = null;

	/**
	 * 初始化一个新创建的 Message 对象，使其表示一个空消息。
	 */
	public ResultDto() {

	}

	/**
	 * 初始化一个新创建的 Message 对象
	 * 
	 * @param type
	 *            类型
	 * @param content
	 *            内容
	 */
	public ResultDto(Type type, String message) {
		this.type = type;
		this.message = message;
	}
	
	public ResultDto(Type type, String message,Object data) {
		this.type = type;
		this.message = message;
		this.data=data;
	}

	/**
	 * @param type
	 *            类型
	 * @param content
	 *            内容
	 * @param args
	 *            参数
	 */
	public ResultDto(Type type, String message, Object... args) {
		this.type = type;
		this.message = message;
	}

	

	
	public static ResultDto success(String message) {
		return new ResultDto(Type.success, message);
	}
	
	public static ResultDto successDate(String message,Object data) {
		return new ResultDto(Type.success, message,data);
	}
	
	public static ResultDto successDate(Object data) {
		return new ResultDto(Type.success, "操作成功",data);
	}
	

	
	
	public static ResultDto error(String message) {
		return new ResultDto(Type.error, message);
	}

	/**
	 * 获取类型
	 * 
	 * @return 类型
	 */
	public Type getType() {
		return type;
	}

	/**
	 * 设置类型
	 * 
	 * @param type
	 *            类型
	 */
	public void setType(Type type) {
		this.type = type;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 设置内容
	 * 
	 * @param content
	 *            内容
	 */
	public void setContent(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	

}